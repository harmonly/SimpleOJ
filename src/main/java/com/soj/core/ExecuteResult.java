package com.soj.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 执行结果
 * 执行{@link Executable#compile()}编译得到的结果
 * 执行{@link Executable#execute()}运行得到的结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExecuteResult {

    /**
     * -1 = 未知错误,
     * 0 = 没有错误,
     * 1 = 编译错误 = CE,
     * 2 = 运行错误,
     * 3 = 超时错误 = TLE,
     * 4 = 答案错误 = WA
     */
    private int error;

    // 错误原因
    private String reason;

    // error = 1
    private String compileResult;

    // error = 0
    private String stdout;

    // error = 2
    private String stderr;

    // error = 0
    // 单位 ms
    private long time;

    // error = 0
    // 单位 KB
    private long memory;
}
