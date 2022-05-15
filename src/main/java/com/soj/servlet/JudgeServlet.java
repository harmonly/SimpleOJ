package com.soj.servlet;

import com.alibaba.fastjson.JSONObject;
import com.soj.entity.Code;
import com.soj.entity.CodeType;
import com.soj.core.JudgeResult;
import com.soj.core.JudgeTask;
import com.soj.entity.User;
import com.soj.utils.JsonUtil;
import com.soj.utils.ResponseCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/judge")
@MultipartConfig()
public class JudgeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject json = JsonUtil.parseJson(req);
        if (json == null) {
            resp.getWriter().write(JsonUtil.getJson(ResponseCode.FAIL, "数据为空", "").toString());
            return;
        }
        String username = json.getString("username");
        String codeType = json.getString("code_type");
        String codeContent = json.getString("code_content");
        int problemId = Integer.parseInt(json.getString("problem_id"));

        JudgeResult result = JudgeTask.judge(User.builder().name(username).build(), Code.builder()
                .content(codeContent)
                .codeType(CodeType.getType(codeType))
                .build(), problemId);
        resp.getWriter().write(JsonUtil.getJson(ResponseCode.SUCCESS, "提交成功", result).toString());
    }
}
