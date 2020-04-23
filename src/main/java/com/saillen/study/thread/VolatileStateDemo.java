package com.saillen.study.thread;

/**
 * @author : saillen
 * @date: 2020/4/18
 **/
public class VolatileStateDemo {

    private volatile int counter;

    public void adder() {
        counter++;
    }

    public void reader() {
        int m = counter + 1;
    }

    public static void main(String[] args) {

    }
}
