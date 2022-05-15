package com.soj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 问题类
 * {@link Problem#id} 存于数据库
 * {@link Problem#name} 存于数据库
 * {@link Problem#difficulty} 存于数据库
 * <p>
 * {@link Problem#desc} 存于本地
 * {@link Problem#explain} 存于本地
 * {@link Problem#input} 存于本地
 * {@link Problem#output} 存于本地
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Problem {
    /**
     * 问题编号, 标识唯一问题
     * 存于数据库
     */
    private int id;
    /**
     * 问题名
     * 存于数据库
     */
    private String name;
    /**
     * 问题难度
     * 1. 简单
     * 2. 中等
     * 3. 困难
     * 存于数据库
     */
    private int difficulty;
    /**
     * 问题描述
     * 存于 .yml
     */
    private String desc;
    /**
     * 示例解释
     * 存于 .yml
     */
    private String explain;
    /**
     * 示例输入
     * 存于 .yml
     */
    private String input;
    /**
     * 示例输出
     * 存于 .yml
     */
    private String output;
}
