package com.saillen.study.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date: 2020/4/21
 **/
public class ExchangerDemo {

    private static final Exchanger<String> changer = new Exchanger<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            String s = "t1 hello";
            try {
                s = changer.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }).start();

        TimeUnit.SECONDS.sleep(3);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String s = "t2 hi";
                try {
                    s = changer.exchange(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s);
            }
        }).start();

        TimeUnit.SECONDS.sleep(100);
    }


}
