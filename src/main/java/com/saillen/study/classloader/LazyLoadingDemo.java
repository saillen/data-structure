package com.saillen.study.classloader;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class LazyLoadingDemo {

    static class P {
        final int i = 9;
        static int j = 8;

        static {
            System.out.println("p init");
        }
    }

    static class M extends P {
        final static int x = 10;

        static {
            System.out.println("x init : " + j);
        }

        int n = 11;
    }

    public static void main(String[] args) {
        // M m;
        // M m2 = new M();
        //System.out.println(M.x);
        System.out.println(P.j);

    }

}
