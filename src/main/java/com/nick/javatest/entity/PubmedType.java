package com.nick.javatest.entity;

import java.util.Arrays;

public enum PubmedType {
    BACKGROUND("BACKGROUND"),
    OBJECTIVE("OBJECTIVE"),
    METHODS("METHODS"),
    RESULTS("RESULTS"),
    CONCLUSIONS("CONCLUSIONS");

    private String type;


    PubmedType(String type) {
        this.type = type;
    }

    public static boolean contain(String type){
        return Arrays.stream(PubmedType.values()).anyMatch(x -> x.type.equals(type));
    }
}
