package com.saillen.study.thread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : saillen
 * @date : 2020-04-15
 */
public class NewLockDemo {

	private final ReentrantLock lock = new ReentrantLock();
	private int count = 0;

	private void count() {
		lock.lock();
		try {
			lock.lockInterruptibly();
			count++;
			try {
				TimeUnit.MINUTES.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void doCounter() {
		for (int i = 0; i < 1_000_000; i++) {
			count();
		}
	}

	public static void main(String[] args) throws Exception {
		NewLockDemo m = new NewLockDemo();
		Thread t1 = new Thread(m::doCounter,"t1");
		Thread t2 = new Thread(m::doCounter,"t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.print(m.count);
	}

}
