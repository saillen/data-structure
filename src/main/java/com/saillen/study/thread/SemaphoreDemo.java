package com.saillen.study.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class SemaphoreDemo {

    private static final Semaphore s = new Semaphore(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    s.acquire();
                    System.out.println(Thread.currentThread().getName() + "acquire success");
                    TimeUnit.SECONDS.sleep(5);
                    s.release();
                    System.out.println(Thread.currentThread().getName() + "release success");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        s.acquire();
        System.out.println("end");
    }
}
