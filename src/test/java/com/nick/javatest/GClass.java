package com.nick.javatest;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GClass{
    private static String a = "aa";


    @Getter
    private static String result = a + "BB";

    public static void printA() {
        log.info(a);
    }

    public static void printResult() {
        log.info(result);
    }


    public static void setA(String a) {
        GClass.a = a;
    }
}
