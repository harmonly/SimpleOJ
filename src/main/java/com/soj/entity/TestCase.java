package com.soj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.OutputStream;
import java.util.List;

/**
 * 测试用例类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestCase {
    /**
     * 对应的问题 id
     */
    private int id;

    /**
     * 测试用例数量
     */
    private int count;

    /**
     * 输入用例 url
     * 格式: id/i.in (i表示第几个测试的输入用例)
     * 样例: 1000/1.in
     */
    private List<String> inputUrls;

    /**
     * 输出用例 url
     * 格式: id/i.out (i表示第几个测试的输出用例)
     * 样例: 1000/1.out
     */
    private List<String> outputUrls;
}
