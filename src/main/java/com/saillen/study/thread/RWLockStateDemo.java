package com.saillen.study.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class RWLockStateDemo {

    static class Config {
        int retryTime = 10;
        String address = "http://www.baidu.com";

        @Override
        public String toString() {
            return "[" + retryTime + "]" + address;
        }
    }

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    private Config cfg = new Config();

    public void readCfg() {
        readLock.lock();
        try {
            // 模拟消费耗时
            TimeUnit.SECONDS.sleep(1);
            System.out.println(cfg);
            LockSupport.park();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void updateCfg() {
        writeLock.lock();
        try {
            Random r = new Random();
            TimeUnit.SECONDS.sleep(r.nextInt(4) + 1);
            cfg.retryTime = r.nextInt(10) + 1;
            System.out.println("update" + cfg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RWLockStateDemo d = new RWLockStateDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    d.readCfg();
                }
            }, "read-t" + i).start();
        }

        Thread t2 = new Thread(() -> {
            while (true) {
                d.updateCfg();
            }
        }, "write-t1");
        t2.start();

        while (true) {
            TimeUnit.SECONDS.sleep(10);
        }
    }
}
