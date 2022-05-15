package com.soj.service.impl;

import com.soj.entity.TestCase;
import com.soj.service.TestCaseService;
import com.soj.utils.FileUtil;
import com.soj.utils.YamlUtil;
import lombok.extern.java.Log;

import java.io.*;
import java.net.URL;

@Log
public class TestCaseServiceImpl implements TestCaseService {

    /**
     * 用于保存问题信息的本地路径
     * 将 %s 替换为 {@link TestCase} id
     */
    private static final String PATH = "D:/all/idea/SimpleOJ/database/testcase/";

    /**
     * 用于保存问题信息的网络路径
     * 将 %s 替换为 {@link TestCase} id
     */
    private static final String URL_PATH = "http://localhost:8080/soj/database/testcase/";

    @Override
    public void addTestCase(TestCase testCase) {
        YamlUtil.create(String.format(PATH, testCase.getId()), testCase);
    }

    @Override
    public void deleteTestCase(int id) {
        FileUtil.deleteFile(String.format(PATH, id));
    }

    @Override
    public TestCase getTestCase(int id) {
        try {
            return YamlUtil.load(new URL(URL_PATH + id + ".yml").openStream(), TestCase.class);
        } catch (IOException e) {
            try {
                return YamlUtil.load(PATH + id + ".yml", TestCase.class);
            } catch (FileNotFoundException ex) {
                log.warning("无法找到问题" + id);
            }
        }
        return null;
    }

    /**
     * 解析 testcase 的输入输入输出 url
     *
     * @see TestCase
     */
    @Override
    public InputStream parseUrl(String url) {
        try {
            return new URL(URL_PATH + url).openStream();
        } catch (IOException e) {
            try {
                return new FileInputStream(PATH + url);
            } catch (FileNotFoundException ex) {
                log.warning("无法找到对应的测试用例");
            }
        }
        return null;
    }
}
