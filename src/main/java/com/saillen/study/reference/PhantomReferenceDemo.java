package com.saillen.study.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/20
 **/
public class PhantomReferenceDemo {

    static class M {
        byte[] bigData = new byte[1024 * 1024 * 10];
    }

    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue q = new ReferenceQueue();
        M m = new M();
        PhantomReference pr = new PhantomReference(m, q);

        new Thread(() -> {
            while (true) {
                Reference f = q.poll();
                if (f != null) {
                    System.out.println("m 被回收：" + f);
                }
            }
        }).start();

        System.out.println(pr.get());
        TimeUnit.SECONDS.sleep(1);
        m = null;
        System.gc();
        TimeUnit.SECONDS.sleep(10);
    }

}
