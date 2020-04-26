package com.saillen.study.thread.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : saillen
 * @date : 2020-04-16
 */
public class LockStateDemo {

	private final ReentrantLock lock = new ReentrantLock(true);
	private int count = 0;

	private void add() {

		try {
			lock.tryLock(1,TimeUnit.SECONDS);
			count++;
			System.out.println(count);
			if("t1".equals(Thread.currentThread().getName()))
				TimeUnit.MINUTES.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws Exception {
		LockStateDemo m = new LockStateDemo();

		List<Thread> tList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			Thread t = new Thread(m::add, "t" + (i + 1));
			tList.add(t);
		}

		for (Thread t : tList) {
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			t.start();
			System.out.println(t.getName() + "start");
		}

		do {
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			for (Thread t : tList) {
				System.out.println(t.getName() + ":" + t.getState());
			}
		} while (true);

	}

}
