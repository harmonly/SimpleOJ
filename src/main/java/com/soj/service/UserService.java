package com.soj.service;

import com.soj.entity.User;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface UserService {

    int addUser(User user);

    int deleteUser(int id);

    User getUser(String username, String password);

    int editUser(User user);

    List<User> getUsers();

    /**
     * 验证用户是否登录成功
     *
     * @param username 用户名
     * @param password 密码
     * @param session  HttpSession
     */
    boolean auth(String username, String password, HttpSession session);

    /**
     * 使用户退出登录
     *
     * @param session HttpSession
     */
    boolean logout(HttpSession session);

    /**
     * 注册用户
     *
     * @param user 用户
     */
    boolean register(User user);
}
