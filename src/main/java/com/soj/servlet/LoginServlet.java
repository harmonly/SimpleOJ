package com.soj.servlet;

import com.soj.service.UserService;
import com.soj.service.impl.UserServiceImpl;
import com.soj.utils.JsonUtil;
import com.soj.utils.ResponseCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (service.auth(username, password, req.getSession())) {
            resp.getWriter().write(JsonUtil.getJson(ResponseCode.SUCCESS, "登录成功", "login-success").toString());
        } else resp.getWriter().write(JsonUtil.getJson(ResponseCode.FAIL, "登录失败", "login-failure").toString());
    }
}
