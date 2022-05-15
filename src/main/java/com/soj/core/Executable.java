package com.soj.core;

/**
 * 编译方法和运行方法接口
 */
public interface Executable {

    /**
     * 编译命令
     * 需要先使用该方法才能使用{@link Executable#execute()}
     *
     * @return {@link ExecuteResult}
     */
    ExecuteResult compile();

    /**
     * 运行命令
     *
     * @return {@link ExecuteResult}
     */
    ExecuteResult execute();

    /**
     * 运行命令
     *
     * @param stdin 标准输入
     * @return {@link ExecuteResult}
     */
    ExecuteResult execute(String stdin);
}
