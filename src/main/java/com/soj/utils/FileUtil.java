package com.soj.utils;

import java.io.*;

/**
 * 工具类，读写文件
 */
public class FileUtil {
    /**
     * 读文件：一把整个文件内容读到 StringBuilder 中
     *
     * @param path 文件路径
     * @return 内容
     */
    public static String readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) sb.append(line).append("\n");
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 写文件：把 content 写到指定文件中
     *
     * @param path    文件路径
     * @param content 写入的内容
     */
    public static void writeFile(String path, String content) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删文件: 删除 path 的文件或文件夹
     *
     * @param path 文件路径
     */
    public static void deleteFile(String path) {
        File dir = new File(path);
        if (!dir.exists()) return;
        if (dir.isFile()) dir.delete();
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files == null) return;
            for (File file : files) if (file.isFile()) file.delete();
            dir.delete();
        }
    }
}
