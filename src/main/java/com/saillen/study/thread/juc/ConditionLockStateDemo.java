package com.saillen.study.thread.juc;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : saillen
 * @date : 2020-04-16
 */
public class ConditionLockStateDemo {
	private final ReentrantLock lock = new ReentrantLock(true);
	private final Condition notEmpty = lock.newCondition();

	private boolean empty = false;

	public void consumer() {
		lock.lock();
		try {
			if (empty) {
				notEmpty.await();
			} else {
				empty = true;
				System.out.println("队列空了");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void producer() {
		lock.lock();
		try {
			if (empty) {
				empty = false;
				System.out.println("队列不空了");
			}
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws IOException {
		ConditionLockStateDemo m = new ConditionLockStateDemo();
		Thread t1 = new Thread(() -> {
			for (;;) {
				m.consumer();
			}
		});
		Thread t2 = new Thread(() -> {
			for (;;) {
				m.consumer();
			}
		});
		Thread t3 = new Thread(m::producer);

		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");

		t1.start();
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		t2.start();
		System.in.read();

		t3.start();

	}

}
