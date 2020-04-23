package com.saillen.study.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/20
 **/
public class SoftReferenceDemo {

    static class M {
        byte[] bigData = new byte[1024 * 1024 * 10];
//        @Override
//        protected void finalize() throws Throwable {
//            System.out.println("...");
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<SoftReference> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            //SoftReference r = new SoftReference(new byte[1024 * 1024 * 10]);
            SoftReference r = new SoftReference(new M());
            list.add(r);
        }

        int i = 0;
        for (SoftReference s : list) {
            System.out.println(i + ":" + s.get());
            i++;
        }
    }

}
