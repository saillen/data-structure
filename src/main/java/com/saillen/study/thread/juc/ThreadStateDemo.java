package com.saillen.study.thread.juc;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date : 2020-04-10
 */
public class ThreadStateDemo {

	private final static Object lock1 = new Object();
	private final static Object lock2 = new Object();
	private final static Object lock3 = new Object();

	public static void main(String[] args) throws Exception {

		// jstack -> run -> Running
		Thread t1 = new Thread(() -> {
			while (true) {
				synchronized (lock1) {
					for (int i = 0; i < 10_000_000; i++) {
						Random r = new Random(100);
						if (r.nextInt() == i) {
							System.out.print(".");
						}
					}
				}
			}
		});

		// jstack -> block -> Blocked
		Thread t2 = new Thread(() -> {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(1);
					synchronized (lock1) {
						System.out.println("-");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// jstack -> block -> TimedWaiting
		final Thread t3 = new Thread(() -> {
			try {
				TimeUnit.MINUTES.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("end");
		});

		// jstack -> block -> TimedWaiting
		Thread t4 = new Thread(() -> {
			try {
				synchronized (lock2) {
					lock2.wait(100000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Thread t5 = new Thread(() -> {
			try {
				synchronized (lock3) {
					lock3.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t6 = new Thread(() -> {

		});

		// set name
		t1.setName("running-thread");
		t2.setName("blocked-thread");
		t3.setName("sleep-thread");
		t4.setName("wait(10000)-thread");
		t5.setName("waiting-thread");

		// start
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		// print state
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		System.out.println(t3.getState());
		System.out.println(t4.getState());
		System.out.println(t5.getState());

		// sleep(1) state
		TimeUnit.SECONDS.sleep(2);
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		System.out.println(t3.getState());
		System.out.println(t4.getState());
		System.out.println(t5.getState());

		t1.join();
	}

}
