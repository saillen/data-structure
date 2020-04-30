package com.saillen.study.thread.interview;

import java.util.concurrent.TimeUnit;

/**
 * 循环交替输出 AB
 *
 * @author : saillen
 * @date : 2020-04-30
 */
public class ABControllerDemo {

    private final Object lock = new Object();

    public void printA() throws InterruptedException {
        synchronized(lock) {
            System.out.println("A");
            lock.notifyAll();
            lock.wait();
        }
    }

    public void printB() throws InterruptedException {
        synchronized(lock) {
            lock.wait();
            System.out.println("B");
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ABControllerDemo d = new ABControllerDemo();
        new Thread(() -> {
            while(true) {
                try {
                    d.printA();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ta").start();

        new Thread(() -> {
            try {
                d.printB();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }, "tb").start();

        TimeUnit.SECONDS.sleep(10000);
    }

}
