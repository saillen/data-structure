package com.saillen.study.reference;

import java.lang.ref.SoftReference;

/**
 * @author : saillen
 * @date: 2020/4/20
 **/
public class SoftReDemo2 {


    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);

        System.out.println(m.get());
        System.gc();
        Thread.sleep(500);
        System.out.println(m.get());

        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(m.get());
    }

}
