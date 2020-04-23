package com.saillen.study.reference;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/20
 **/
public class WeakReferenceDemo {

    static class M {
        byte[] bigData = new byte[1024 * 1024 * 10];
    }

    public static void main(String[] args) throws InterruptedException {
        final WeakReference<M> wk = new WeakReference<>(new M());

        Thread t2 = new Thread(() -> {
            while (wk.get() != null) {
                //System.out.println("存活：" + wk.get());
            }
            System.out.println("可以销毁 wk 了：" + wk.get());
        });
        t2.start();

        TimeUnit.SECONDS.sleep(1);
        //m = null;
        System.gc();
        TimeUnit.SECONDS.sleep(10);
    }

}
