package com.soj.service.impl;

import com.soj.dao.UserMapper;
import com.soj.entity.User;
import com.soj.service.UserService;
import com.soj.utils.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import lombok.extern.java.Log;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Log
public class UserServiceImpl implements UserService {

    @Override
    public int addUser(User user) {
        try (SqlSession session = MybatisUtil.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.addUser(user);
        }
    }

    @Override
    public int deleteUser(int id) {
        try (SqlSession session = MybatisUtil.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.deleteUser(id);
        }
    }

    @Override
    public User getUser(String username, String password) {
        try (SqlSession session = MybatisUtil.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getUser(username, password);
        }
    }

    @Override
    public int editUser(User user) {
        try (SqlSession session = MybatisUtil.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.editUser(user);
        }
    }

    @Override
    public List<User> getUsers() {
        try (SqlSession session = MybatisUtil.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.getUsers();
        }
    }

    @Override
    public boolean auth(String username, String password, HttpSession session) {
        User user = getUser(username, password);
        if (user == null) return false;
        session.setAttribute("user", user);
        return true;
    }

    @Override
    public boolean logout(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
            return true;
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        try {
            this.addUser(user);
            return true;
        } catch (PersistenceException e) {
            log.warning("用户" + user + "注册失败!");
            return false;
        }
    }
}
