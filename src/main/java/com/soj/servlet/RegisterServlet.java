package com.soj.servlet;

import com.soj.entity.User;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("[注册]:" + username + " " + password);
        if (username.equals("") || password.equals("")) {
            resp.getWriter().write(JsonUtil.getJson(ResponseCode.FAIL, "用户名或密码为空", "register-failure").toString());
            return;
        }
        User user = User.builder()
                .name(username)
                .password(password)
                .build();
        if (service.register(user)) {
            resp.getWriter().write(JsonUtil.getJson(ResponseCode.SUCCESS, "注册成功", "register-success").toString());
        } else resp.getWriter().write(JsonUtil.getJson(ResponseCode.FAIL, "注册失败", "register-failure").toString());
    }
}
