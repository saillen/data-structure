package com.saillen.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 先 unpark 然后在 park 能否唤醒？
 *
 * @author : saillen
 * @date : 2020-04-30
 */
public class LockSupport_Test {

    static Thread t1;
    static Thread t2;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch(InterruptedException e) {
            }

            LockSupport.park();
            System.out.println("t1-1");
            LockSupport.park();
            System.out.println("t1-2");

        });

        t2 = new Thread(() -> {
            LockSupport.unpark(t1);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();

        while(true) {
        }

    }

}
