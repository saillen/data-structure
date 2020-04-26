package com.saillen.study.thread.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author : saillen
 * @date : 2020-04-17
 */
public class FutureTaskDemo {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();

		Future<String> f = exec.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				TimeUnit.SECONDS.sleep(10);
				return "h";
			}
		});

		String h = f.get();
        System.out.println(h);
	}

}
