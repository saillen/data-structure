package com.saillen.study.thread.foo;

/**
 * @author : saillen
 * @date: 2020/4/16
 **/
public class Foo_Volatile {
    private volatile int curStep = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        if (curStep == 1) {
            printFirst.run();
            curStep = 2;
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (true) {
            if (curStep == 2) {
                printSecond.run();
                curStep = 3;
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        for (; ; ) {
            if (curStep == 3) {
                printThird.run();
                break;
            }
        }
    }

}
