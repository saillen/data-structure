package com.saillen.study.thread.foo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : saillen
 * @date: 2020/4/16
 **/
public class Foo_ReentrantLock {

    private ReentrantLock lock = new ReentrantLock();
    private Condition ifOneRun = lock.newCondition();
    private Condition ifTowRun = lock.newCondition();

    public void first(Runnable r) throws InterruptedException {
        r.run();
        ifOneRun.signal();
    }

    public void second(Runnable r) throws InterruptedException {
        ifOneRun.await();
        r.run();
        ifTowRun.signal();
    }

    public void third(Runnable r) throws InterruptedException {
        ifTowRun.await();
        r.run();
    }

}
