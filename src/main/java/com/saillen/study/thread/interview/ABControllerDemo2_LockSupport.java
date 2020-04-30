package com.saillen.study.thread.interview;

import java.util.concurrent.locks.LockSupport;

/**
 * @author : saillen
 * @date : 2020-04-30
 */
public class ABControllerDemo2_LockSupport {

    public void printA(Thread tb) {
        System.out.print("A");
        // 如果 tb 还没有 park 这个时候 unpark 一次没问题的
        LockSupport.unpark(tb);
        LockSupport.park();
    }

    public void printB(Thread ta) {
        LockSupport.park();
        System.out.print("B");
        LockSupport.unpark(ta);
    }

    static Thread ta;
    static Thread tb;

    public static void main(String[] args) {
        ABControllerDemo2_LockSupport d = new ABControllerDemo2_LockSupport();
        ta = new Thread(() -> {
            while(true) {
                d.printA(tb);
            }
        }, "ta");

        tb = new Thread(() -> {
            while(true) {
                d.printB(ta);
            }
        }, "tb");
        ta.start();
        tb.start();
        while(true) {
        }
    }
}
