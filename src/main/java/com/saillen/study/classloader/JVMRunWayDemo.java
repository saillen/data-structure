package com.saillen.study.classloader;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class JVMRunWayDemo {

    static void m() {
        for (int i = 0; i < 9_000L; i++) {
            int j = i % 3;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int j = 0; j < 9_000L; j++) {
            m();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
