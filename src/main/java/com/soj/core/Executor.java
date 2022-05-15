package com.soj.core;

import com.soj.entity.Code;
import com.soj.entity.User;
import com.soj.utils.FileUtil;
import lombok.extern.java.Log;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 执行器
 * 1. 创建工作目录
 * 2. 构造对应语言的编译和运行命令和运行环境
 * 3. 实现 {@link Executable}
 */
@Log
public class Executor implements Executable {
    private static final String FILENAME = "Solution"; // 文件名
    private final Code code; // 代码
    private String WORKDIR; // 工作目录
    private String compileCmd = null; // 编译命令
    private String executeCmd = null; // 运行命令
    private String[] envp = null; // cmd运行环境
    private boolean isCompile = false; // 是否已经编译

    public Executor(User user, Code code) {
        this.code = code;

        // 创建一个新的工作目录
        WORKDIR = "./soj/" + user.getName() + "/";
        FileUtil.deleteFile(WORKDIR);
        if (!new File(WORKDIR).mkdirs()) {
            log.warning("工作目录未能成功创建");
            return;
        }

        // 存好对应的文件, 给定编译或运行的命令
        switch (code.getCodeType()) {
            case C: {
                FileUtil.writeFile(WORKDIR + FILENAME + ".c", code.getContent());
                compileCmd = String.format("gcc %s -o %s", WORKDIR + FILENAME + ".c", WORKDIR + FILENAME);
                executeCmd = String.format("cmd /c cd %s && %s", WORKDIR, FILENAME);
                envp = null;
                break;
            }
            case CPP: {
                FileUtil.writeFile(WORKDIR + FILENAME + ".cpp", code.getContent());
                compileCmd = String.format("g++ %s -o %s", WORKDIR + FILENAME + ".cpp", WORKDIR + FILENAME);
                executeCmd = String.format("cmd /c cd %s && %s", WORKDIR, FILENAME);
                envp = null;
                break;
            }
            case JAVA: {
                FileUtil.writeFile(WORKDIR + FILENAME + ".java", code.getContent());
                compileCmd = String.format("javac %s -encoding UTF-8 -d %s", WORKDIR + FILENAME + ".java", WORKDIR);
                executeCmd = String.format("java -classpath %s %s", WORKDIR, FILENAME);
                envp = new String[]{"Path=D:\\Java\\jdk-16.0.1\\bin"};
                break;
            }
            case PYTHON: {
                FileUtil.writeFile(WORKDIR + FILENAME + ".py", code.getContent());
                executeCmd = String.format("python %s", WORKDIR + FILENAME + ".py");
                envp = null;
                break;
            }
            case VOID: {
                log.warning("[executor]无法识别代码类型");
            }
        }
    }

    @Override
    public ExecuteResult compile() {
        if (compileCmd == null)
            return ExecuteResult.builder()
                    .error(-1)
                    .reason("没有编译命令")
                    .build();
        try {
            Process process = Runtime.getRuntime().exec(compileCmd);

            String compileResult = IOUtils.toString(process.getErrorStream(), "GBK");
            if (compileResult == null || !compileResult.equals("")) {
                return ExecuteResult.builder()
                        .error(1)
                        .reason("编译出错")
                        .compileResult(compileResult)
                        .build();
            }
            process.waitFor();
            this.isCompile = true;
            return ExecuteResult.builder()
                    .error(0)
                    .build();
        } catch (IOException e) {
            log.warning("[编译] 流错误");
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.warning("[编译] Process 中断错误");
            e.printStackTrace();
        }
        return ExecuteResult.builder()
                .error(-1)
                .reason("未知错误")
                .build();
    }

    @Override
    public ExecuteResult execute() {
        return this.execute(code.getStdin());
    }

    @Override
    public ExecuteResult execute(String stdin) {
        if (executeCmd == null)
            return ExecuteResult.builder()
                    .error(-1)
                    .reason("没有运行命令")
                    .build();
        if (!isCompile)
            return ExecuteResult.builder()
                    .error(-1)
                    .reason("没有进行编译")
                    .build();
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(executeCmd, envp);
            this.killProcess(runtime, process);
            long memory = this.getMemory(runtime, process.pid());
            long bTime = System.currentTimeMillis();

            IOUtils.write(stdin, process.getOutputStream(), StandardCharsets.UTF_8);
            process.getOutputStream().close();

            String stderr = IOUtils.toString(process.getErrorStream(), "GBK");
            if (!stderr.equals("")) {
                return ExecuteResult.builder()
                        .error(2)
                        .stderr(stderr)
                        .reason("运行出错")
                        .build();
            }
            process.getErrorStream().close();

            String stdout = IOUtils.toString(process.getInputStream(), "GBK");
            process.getInputStream().close();
            long eTime = System.currentTimeMillis();

            process.waitFor();

            return ExecuteResult.builder()
                    .error(0)
                    .stdout(stdout)
                    .stderr(stderr)
                    .time(eTime - bTime)
                    .memory(memory)
                    .build();
        } catch (IOException e) {
            log.warning("[运行] 流错误");
            e.printStackTrace();
        } catch (InterruptedException e) {
            log.warning("[运行] Process 中断错误");
            e.printStackTrace();
        }
        return ExecuteResult.builder()
                .error(-1)
                .reason("未知错误")
                .build();
    }

    /**
     * 延时杀死进程
     *
     * @param runtime {@link Runtime}
     * @param process {@link Process}
     */
    private void killProcess(Runtime runtime, Process process) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    if (!process.isAlive()) return;
                    runtime.exec(String.format("TASKKILL /PID %s /T /F", process.pid())).waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 5000);
    }

    /**
     * 获得进程的内存使用
     *
     * @param runtime {@link Runtime}
     * @param pid     进程id
     * @return 内存使用量 单位KB
     */
    private long getMemory(Runtime runtime, long pid) throws IOException, InterruptedException {
        Process memoryProcess = runtime.exec(String.format("TASKLIST /FI \"PID eq %s\"", pid));
        memoryProcess.waitFor();
        String line = IOUtils.toString(memoryProcess.getInputStream(), "GBK");
        int idx = line.lastIndexOf('K');
        if (idx != -1)
            return Long.parseLong(line.substring(idx - 11, idx)
                    .replaceAll(",", "")
                    .replaceAll(" ", ""));
        return 0;
    }
}
