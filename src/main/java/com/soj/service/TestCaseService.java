package com.soj.service;

import com.soj.entity.TestCase;

import java.io.InputStream;

public interface TestCaseService {

    void addTestCase(TestCase testCase);

    void deleteTestCase(int id);

    TestCase getTestCase(int id);

    InputStream parseUrl(String url);
}