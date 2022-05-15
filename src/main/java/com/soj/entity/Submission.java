package com.soj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户提交类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Submission {

    /**
     * 提交 id
     */
    private int id;

    /**
     * 用户 id
     */
    private int userId;

    /**
     * 题目 id
     */
    private int problemId;
}
