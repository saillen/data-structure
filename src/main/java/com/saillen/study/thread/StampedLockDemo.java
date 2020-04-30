package com.saillen.study.thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock和ReadWriteLock相比，改进之处在于：读的过程中也允许获取写锁后写入！
 * 这样一来，我们读的数据就可能不一致，所以，需要一点额外的代码来判断读的过程中是否有写入，
 * 这种读锁是一种乐观锁。
 *
 * StampedLock提供了乐观读锁，可取代ReadWriteLock以进一步提升并发性能；
 *
 * StampedLock是不可重入锁。
 *
 * @author : saillen
 * @date: 2020/4/21
 **/
public class StampedLockDemo {

    private final StampedLock lock = new StampedLock();

    private int count;

    public void update() {
        long stamped = lock.writeLock();
        try {
            Random random = new Random();
            count += random.nextInt(100);
        } finally {
            lock.unlock(stamped);
        }
    }

    public void get() {
        long stamped = lock.tryOptimisticRead();

        int cnt = count;
        int cnt2 = -1;
        String str = "";
        if(cnt % 2 == 0) {
            str = "是 2 的倍数";
        }
        if(!lock.validate(stamped)) {
            long l = lock.readLock();
            try {
                cnt2 = count;
            } finally {
                lock.unlock(l);
            }
        }
        if(cnt2 != -1) {
            System.out.println("第一读取到[" + cnt + "],第二次读取到[" + cnt2 + "]");
        }

    }

    public static void main(String[] args) throws InterruptedException {

        StampedLockDemo demo = new StampedLockDemo();

        new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                demo.update();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t-2-1").start();

        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                for(; ; ) {
                    demo.get();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(100);
    }
}
