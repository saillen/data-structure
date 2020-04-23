package com.saillen.study.reference;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class ThreadLocalDemo {

    private static final ThreadLocal<String> t = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            String s = t.get();
            System.out.println(s);
            t.set("t12");
            t.set("t11");
            System.out.println(t.get());
        }, "t1").start();

        new Thread(() -> {
            String s = t.get();
            System.out.println(s);
            t.set("t21");
            t.set("t22");
            System.out.println(t.get());
        }, "t2").start();

        TimeUnit.SECONDS.sleep(100);

    }

}
