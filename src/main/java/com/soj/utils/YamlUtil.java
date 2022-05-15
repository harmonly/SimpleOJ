package com.soj.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URL;

/**
 * 工具类, 方便读写 yml 文件
 */
public class YamlUtil {

    /**
     * 加载 yaml 到 type 类里面
     *
     * @param path 读取路径
     * @param type 读取文件的类型
     * @return 对应的类型
     */
    public static <T> T load(String path, Class<T> type) throws FileNotFoundException {
        return new Yaml().loadAs(new FileInputStream(path), type);
    }

    /**
     * 加载 yaml 到 type 类里面
     *
     * @param inputStream 输入流
     * @param type        读取文件的类型
     * @return 对应的类型
     */
    public static <T> T load(InputStream inputStream, Class<T> type) {
        return new Yaml().loadAs(inputStream, type);
    }

    /**
     * 读取 data 对象数据, 写入 yml 文件中
     *
     * @param path 存放路径
     * @param data 对象数据
     */
    public static void create(String path, Object data) {
        Yaml yaml = new Yaml();
        try {
            yaml.dump(data, new FileWriter(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取 data 对象数据, 写入 yml 文件中
     *
     * @param outputStream 输出流
     * @param data         对象数据
     */
    public static void create(OutputStream outputStream, Object data) {
        new Yaml().dump(data, new OutputStreamWriter(outputStream));
    }
}
