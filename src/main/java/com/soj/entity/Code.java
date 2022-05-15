package com.soj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户提交的代码
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Code {
    /**
     * 代码类型
     * {@link CodeType}
     */
    private CodeType codeType = CodeType.VOID;

    /**
     * 代码内容
     */
    private String content;

    /**
     * 标准输入
     */
    private String stdin;
}
