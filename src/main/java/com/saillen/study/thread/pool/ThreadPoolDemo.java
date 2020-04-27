package com.saillen.study.thread.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : saillen
 * @date: 2020/4/27
 **/
public class ThreadPoolDemo {

    private static ExecutorService pool = new ThreadPoolExecutor(10, 30, 10, TimeUnit.SECONDS,
            new ArrayBlockingQueue(5),
            Executors.defaultThreadFactory(), (r, executor) -> System.out.println("save 2 db" + executor.toString()));
    //private static ExecutorService pool = Executors.newCachedThreadPool();

    private static AtomicInteger cnt = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    int i = cnt.incrementAndGet();
                    System.out.println("启动" + i);
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("结束" + i);
                }
            });
        }

        // pool.shutdown();

        TimeUnit.SECONDS.sleep(10000);
    }

}
