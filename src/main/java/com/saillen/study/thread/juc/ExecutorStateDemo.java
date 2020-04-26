package com.saillen.study.thread.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date : 2020-04-20
 */
public class ExecutorStateDemo {

	// private static ExecutorService pool = Executors.newFixedThreadPool(2);
	private static ExecutorService pool = new ThreadPoolExecutor(1, 1, 100, TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(5));

	public static void main(String[] args) throws Exception {
		int size = 10;
		for (int i = 0; i < size; i++) {
			pool.execute(() -> {
				System.out.println("a");
				try {
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		TimeUnit.SECONDS.sleep(10);
	}

}
