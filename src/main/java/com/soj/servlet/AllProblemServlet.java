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
import java.util.List;

@WebServlet("/all-problem")
public class AllProblemServlet extends HttpServlet {

    static ProblemService service = new ProblemServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Problem> list = service.getProblems();
        if (list.size() != 0)
            resp.getWriter().write(JsonUtil.getJson(ResponseCode.SUCCESS, "获取问题成功", list).toString());
        else resp.getWriter().write(JsonUtil.getJson(ResponseCode.FAIL, "获取问题失败", null).toString());
    }
}
