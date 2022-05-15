package com.soj.core;

import com.soj.entity.TestCase;
import com.soj.entity.User;
import com.soj.entity.Code;
import com.soj.service.TestCaseService;
import com.soj.service.impl.TestCaseServiceImpl;
import lombok.extern.java.Log;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 判题类, 使用测试用例判断用户代码是否正确
 */
@Log
public class JudgeTask {

    /**
     * 用户使用代码提交对应的问题
     *
     * @param user      {@link User}
     * @param problemId 问题 id
     * @param code      {@link Code}
     * @return {@link JudgeResult}
     */
    public static JudgeResult judge(User user, Code code, int problemId) {
        Executor executor = new Executor(user, code);

        // 1. 编译
        log.info(String.format("[%s]:开始编译", user.getName()));
        ExecuteResult compileResult = executor.compile();
        if (compileResult.getError() == 1)
            return new JudgeResult(compileResult);

        // 2. 获取测试用例
        TestCaseService service = new TestCaseServiceImpl();
        TestCase testCase = service.getTestCase(problemId);
        if (testCase == null)
            return new JudgeResult()
                    .setError(-1)
                    .setReason("此问题不存在");

        // 3. 判断正确
        List<String> inputUrls = testCase.getInputUrls();
        List<String> outputUrls = testCase.getOutputUrls();
        int n = testCase.getCount();
        JudgeResult judgeResult = new JudgeResult().setCount(n);
        log.info(String.format("[%s]:开始判断%s号问题", user.getName(), problemId));
        // 3.1 每个测试用例的判断
        for (int i = 0; i < n; i++) {
            // 3.1 获取测试用例的输入和输出
            String input, output;
            try {
                input = IOUtils.toString(service.parseUrl(inputUrls.get(i)), StandardCharsets.UTF_8);
                output = IOUtils.toString(service.parseUrl(outputUrls.get(i)), StandardCharsets.UTF_8);
            } catch (IOException e) {
                log.warning("读取测试用例错误");
                input = output = null;
            }
            if (input == null || output == null)
                return judgeResult
                        .setError(-1)
                        .setReason("服务器内部错误")
                        .setDoneCount(i);
            // 3.3 执行
            ExecuteResult result = executor.execute(input);
            // 3.4 错误
            if (result.getError() != 0)
                return judgeResult
                        .setError(result.getError())
                        .setStderr(result.getStderr())
                        .setReason(result.getReason())
                        .setDoneCount(i);
            // 3.5 超时
            if (result.getTime() >= 1000)
                return judgeResult
                        .setError(3)
                        .setErrorTestCase(inputUrls.get(i))
                        .setReason("超出时间限制")
                        .setTime(result.getTime())
                        .setDoneCount(i);
            // 3.6 回答为空
            String stdout = result.getStdout();
            if (stdout == null)
                return judgeResult
                        .setError(4)
                        .setStdout(result.getStdout())
                        .setReason("未知输出")
                        .setDoneCount(i);
            stdout = stdout
                    .replace("\r", "")
                    .trim();
            // 3.7 回答错误
            if (!output.replace("\r", "").trim().equals(stdout))
                return judgeResult
                        .setError(4)
                        .setStdout(stdout)
                        .setReason("答案错误")
                        .setDoneCount(i);
            judgeResult.addTime(result.getTime());
            judgeResult.addMemory(result.getMemory());
        }

        return judgeResult
                .setAccepted(true)
                .setTime(judgeResult.getTime() / n)
                .setMemory(judgeResult.getMemory() / n)
                .setDoneCount(n);
    }
}
