package com.saillen.study.reference;

import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/20
 **/
public class StrongReferenceDemo {

    static class M {
        byte[] bigData = new byte[1024 * 1024 * 1024];

        @Override
        protected void finalize() throws Throwable {
            System.out.println("strong finalize");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        M m = new M();
        System.gc();
        m = null;
        System.gc();

        TimeUnit.SECONDS.sleep(100);
    }

}
