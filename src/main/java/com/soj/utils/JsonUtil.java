package com.soj.utils;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * 返回 json 格式
 * 1. code: 响应业务状态
 * 2. message: 响应消息
 * 3. data: 响应中的数据
 */
public class JsonUtil {

    /**
     * 解析{@link HttpServletRequest}的数据
     *
     * @return {@link JSONObject} json对象
     */
    public static JSONObject parseJson(HttpServletRequest req) {
        try {
            return JSONObject.parseObject(IOUtils.toString(req.getReader()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回 {@link JSONObject}
     *
     * @param data 数据
     */
    public static JSONObject getJson(Object data) {
        JSONObject json = new JSONObject();
        json.put("code", ResponseCode.SUCCESS.value);
        json.put("data", data);
        return json;
    }

    /**
     * 返回 {@link JSONObject}
     *
     * @param code    {@link ResponseCode}
     * @param message 消息
     * @param data    数据
     */
    public static JSONObject getJson(ResponseCode code, String message, Object data) {
        JSONObject json = new JSONObject();
        json.put("code", code.value);
        json.put("message", message);
        json.put("data", data);
        return json;
    }
}
