package com.saillen.study.thread.foo;

/**
 * @author : saillen
 * @date: 2020/4/16
 **/
public class Foo_Waiter {
    private int curStep = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        // 优化，first 上就可以打印了
        if (curStep == 1) {
            printFirst.run();
            synchronized (this) {
                curStep = 2;
                this.notifyAll();
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        for (; ; ) {
            if (curStep == 2) {
                printSecond.run();
                synchronized (this) {
                    curStep = 3;
                    this.notifyAll();
                }
                break;
            } else {
                synchronized (this) {
                    // 这里题目注定不会 1 -> 3，所以就 wait 就行了
                    this.wait();
                }
            }
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        while (true) {
            if (curStep == 3) {
                printThird.run();
                break;
            } else {
                // 一直循环检查是否是 3 了，如果不是就去 wait
                synchronized (this) {
                    // 这里一定要有,没有就可能就僵住了，eg curSetp 为 2 ，thrid 起来了，
                    this.notifyAll();
                    this.wait();
                }
            }
        }
    }
}
