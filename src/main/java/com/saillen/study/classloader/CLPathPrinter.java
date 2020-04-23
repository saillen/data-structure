package com.saillen.study.classloader;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class CLPathPrinter {

    public static void main(String[] args) {
        //log(System.getProperty("com."));
        log(CLPathPrinter.class.getClassLoader().toString());
    }

    private static void log(String s) {
        System.out.println(s.replace(";", System.lineSeparator()));
    }

}
