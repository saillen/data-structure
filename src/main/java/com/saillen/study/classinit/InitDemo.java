package com.saillen.study.classinit;

/**
 * @author : saillen
 * @date: 2020/4/22
 **/
public class InitDemo {

    static class T {

        static T t = new T();
        static int count = 2 ;


        private int m = 8;

        private T() {
            count++;
            // System.out.println("count:" + count);
        }
    }

    public static void main(String[] args) {
        System.out.println(T.count);
    }

}
