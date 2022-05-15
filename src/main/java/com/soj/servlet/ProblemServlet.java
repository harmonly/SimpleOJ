package com.soj.servlet;

import com.soj.entity.Problem;
import com.soj.service.ProblemService;
import com.soj.service.impl.ProblemServiceImpl;
import com.soj.utils.JsonUtil;
import com.soj.utils.ResponseCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/problem")
public class ProblemServlet extends HttpServlet {

    static ProblemService service = new ProblemServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int problemId = Integer.parseInt(req.getParameter("problem_id"));
        System.out.println("[题目]:" + problemId);
        Problem problem = service.getProblem(problemId);
        if (problem != null)
            resp.getWriter().write(JsonUtil.getJson(ResponseCode.SUCCESS, "获取问题成功", problem).toString());
        else resp.getWriter().write(JsonUtil.getJson(ResponseCode.FAIL, "获取问题失败", null).toString());
    }
}
