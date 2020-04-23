package com.saillen.study.thread.foo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;

/**
 * @author : saillen
 * @date: 2020/4/16
 **/
public class Foo_Semaphore {

    private final Semaphore secondRun = new Semaphore(0);
    private final Semaphore thirdRun = new Semaphore(0);

    public void first(Runnable r) throws InterruptedException {
        r.run();
        secondRun.release();
    }

    public void second(Runnable r) throws InterruptedException {
        secondRun.acquire();
        r.run();
        thirdRun.release();
    }

    public void third(Runnable r) throws InterruptedException {
        thirdRun.acquire();
        r.run();
    }

}
