package com.saillen.study.cacheline;

/**
 * @author : saillen
 * @date: 2020/4/22
 **/
public class CacheLineDemo {

    static class T {
        // long x = 0L;
        // volatile long x = 0L;
        // long p1, p2, p3, p4, p5, p6, p7;
        // long x = 0L;
        //long p1, p2, p3, p4, p5, p6, p7;
        volatile long x = 0L;
        //long p8, p9, p10, p11, p12, p13, p14;
    }


    public static void main(String[] args) throws InterruptedException {
        T[] arr = new T[]{new T(), new T()};
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000_000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000_000L; i++) {
                arr[1].x = i;
            }
        });

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(System.currentTimeMillis() - start);
    }

}
