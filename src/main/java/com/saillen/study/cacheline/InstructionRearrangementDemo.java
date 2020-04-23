package com.saillen.study.cacheline;

import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/22
 **/
public class InstructionRearrangementDemo {
    private static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; ; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() -> {
                shortWait(100000);
                a = 1;
                x = b;
            });

            Thread two = new Thread(() -> {
                b = 1;
                y = a;
            });

            one.start();
            two.start();
            one.join();
            two.join();

            String str = "第" + i + "次循环(x = " + x + ",y = " + y + ")";
            if (x == 0 && y == 0) {
                System.err.println(str);
                break;
            }
        }
    }

    private static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }

}
