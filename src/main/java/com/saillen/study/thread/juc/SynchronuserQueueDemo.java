package com.saillen.study.thread.juc;

import java.util.concurrent.SynchronousQueue;

/**
 * @author : saillen
 * @date : 2020-04-22
 */
public class SynchronuserQueueDemo {

    private final static  SynchronousQueue<String> q = new SynchronousQueue<>();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                q.take();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
