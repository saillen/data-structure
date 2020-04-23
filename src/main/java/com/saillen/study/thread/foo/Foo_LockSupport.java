package com.saillen.study.thread.foo;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : saillen
 * @date: 2020/4/16
 **/
public class Foo_LockSupport {

    private int curStep = 1;
    public Thread t2, t3;


    public void first(Runnable r) throws InterruptedException {
        if (curStep == 1) {
            r.run();
            curStep = 2;
            LockSupport.unpark(t2);
        }
    }

    public void second(Runnable r) throws InterruptedException {
        while (true) {
            if (curStep == 2) {
                r.run();
                curStep = 3;
                LockSupport.unpark(t3);
                break;
            } else {
                LockSupport.park();
            }
        }
    }

    public void third(Runnable r) throws InterruptedException {
        for (; ; ) {
            if (curStep == 3) {
                r.run();
                break;
            } else {
                LockSupport.park();
            }
        }
    }


}
