package com.soj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    /**
     * 默认id, 标示唯一用户
     */
    private int id;

    /**
     * 用户名字, 标识唯一用户
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;
}
