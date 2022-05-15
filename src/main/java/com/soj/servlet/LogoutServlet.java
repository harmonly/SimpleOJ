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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (service.logout(req.getSession()))
            resp.getWriter().write(JsonUtil.getJson(ResponseCode.SUCCESS, "退出成功", "logout-success").toString());
        else resp.getWriter().write(JsonUtil.getJson(ResponseCode.FAIL, "退出失败", "logout-failure").toString());
    }
}
