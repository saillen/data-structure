package com.saillen.study.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class CountDownLatchDemo {

    private final static CountDownLatch latch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    latch.countDown();
                    System.out.println(latch.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        latch.await();
        System.out.println("end");
        TimeUnit.SECONDS.sleep(5);
    }

}
