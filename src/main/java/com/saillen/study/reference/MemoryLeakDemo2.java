package com.saillen.study.reference;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * value 无法被回收掉，如果 value 非常大，或者 thread 非常多，导致 key 为 null 的 value 的总和非常多。
 * <p>
 * memory leak ： 不管大小都是 leak，这里让 demo  oom，只是为了不用 jconsole 等工具，更直观点；
 *
 * @author : saillen
 * @date: 2020/4/24
 **/
public class MemoryLeakDemo2 {

    static class ImageData {
        long[] bigData = new long[100 * 1024 * 1024];
    }

    static ThreadLocal<ImageData> bigDataHolder = new ThreadLocal<>();

    static ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            pool.execute(() -> {
                bigDataHolder.set(new ImageData());
                //bigDataHolder.remove();
            });
        }

        TimeUnit.SECONDS.sleep(1000);
    }

}
