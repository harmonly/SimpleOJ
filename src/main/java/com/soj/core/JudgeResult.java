package com.soj.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 运行 {@link JudgeTask} 产生的结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudgeResult {
    /**
     * 代表是否正确
     */
    private boolean accepted = false;
    /**
     * -1 = 未知错误
     * 0 = 没有错误
     * 1 = 编译错误 = CE
     * 2 = 运行错误
     * 3 = 超时错误 = TLE
     * 4 = 答案错误 = WA
     */
    private int error;

    private String reason;    // 错误原因

    private String compileResult;    // error = 1

    private String stdout;    // error = 0

    private String stderr;    // error = 2

    private long time;  // error = 0 单位 ms

    private long memory;  // error = 0 单位 KB

    private int count;    // 测试用例个数

    private int doneCount;     // 当前的测试用例回答数

    private String errorTestCase;   // 错误的测试用例

    public JudgeResult(ExecuteResult executeResult) {
        this.error = executeResult.getError();
        this.reason = executeResult.getReason();
        this.compileResult = executeResult.getCompileResult();
        this.stdout = executeResult.getStdout();
        this.stderr = executeResult.getStderr();
        this.time = executeResult.getTime();
        this.memory = executeResult.getMemory();
    }

    public JudgeResult setAccepted(boolean accepted) {
        this.accepted = accepted;
        return this;
    }

    public JudgeResult setError(int error) {
        this.error = error;
        return this;
    }

    public JudgeResult setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public JudgeResult setCompileResult(String compileResult) {
        this.compileResult = compileResult;
        return this;
    }

    public JudgeResult setStdout(String stdout) {
        this.stdout = stdout;
        return this;
    }

    public JudgeResult setStderr(String stderr) {
        this.stderr = stderr;
        return this;
    }

    public JudgeResult setTime(long time) {
        this.time = time;
        return this;
    }

    public JudgeResult addTime(long time) {
        this.time += time;
        return this;
    }

    public JudgeResult setMemory(long memory) {
        this.memory = memory;
        return this;
    }

    public JudgeResult addMemory(long memory) {
        this.memory += memory;
        return this;
    }

    public JudgeResult setCount(int count) {
        this.count = count;
        return this;
    }

    public JudgeResult setDoneCount(int doneCount) {
        this.doneCount = doneCount;
        return this;
    }

    public JudgeResult setErrorTestCase(String errorTestCase) {
        this.errorTestCase = errorTestCase;
        return this;
    }
}
