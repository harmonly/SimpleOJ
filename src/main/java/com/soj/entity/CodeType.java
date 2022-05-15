package com.soj.entity;


import java.util.HashMap;

/**
 * 高级语言类型枚举
 */
public enum CodeType {
    VOID("void"),

    C("c"),

    CPP("cpp"),

    JAVA("java"),

    PYTHON("python");

    public String value;

    private static final HashMap<String, CodeType> map;

    static {
        map = new HashMap<>();
        map.put(VOID.value, VOID);
        map.put(CPP.value, C);
        map.put(CPP.value, CPP);
        map.put(JAVA.value, JAVA);
        map.put(PYTHON.value, PYTHON);
    }

    CodeType(String value) {
        this.value = value;
    }

    public static CodeType getType(String type) {
        return map.get(type);
    }
}