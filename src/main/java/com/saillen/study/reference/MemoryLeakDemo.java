package com.saillen.study.reference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 这里带来的问题就是，ThreadLocal 的  key 一直被强引用，导致 不会出现 key 为 null 的值
 * <p>
 * https://blog.csdn.net/zhailuxu/article/details/79067467
 *
 * @author : saillen
 * @date: 2020/4/24
 **/
public class MemoryLeakDemo {

    ThreadLocal<MemoryLeakDemo> tLocal = new ThreadLocal<>();
    String name;
    byte[] bigData = new byte[1024 * 1024 * 10];

    MemoryLeakDemo(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; ; j++) {
                    MemoryLeakDemo d = new MemoryLeakDemo("name" + j);
                    d.tLocal.set(d);
                    //d.tLocal.remove();
                }
            }, "t" + i));
        }

        for (Thread t : list) {
            t.start();
        }

        for (Thread t : list) {
            t.join();
        }
    }

}
