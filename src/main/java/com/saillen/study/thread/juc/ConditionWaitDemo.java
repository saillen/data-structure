package com.saillen.study.thread.juc;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : saillen
 * @date : 2020-04-16
 */
public class ConditionWaitDemo {

	private final ReentrantLock lock = new ReentrantLock(true);
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();

	private int[] nums = new int[4];
	private int size = 0;
	private int nextConsumerIdx = 0;
	private int nextProducerIdx = 0;

	public void consumer() {
		for (;;) {
			lock.lock();
			//System.out.println("消费者：进入仓库准备工作...");
			try {
				// 如果空了则通知生产，然后在"阻塞等着"
				if (size == 0) {
					System.out.println("空了，开除点消费者吧");
					notEmpty.await();
				}
				System.out.printf("消费: nextConsumerIdx = %s,Size = %s,content = %s \n", nextConsumerIdx, size,
						nums[nextConsumerIdx]);
				nextConsumerIdx = ++nextConsumerIdx % nums.length;
				size--;
				notFull.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			doSleep(1);
		}
	}

	public void producer() {
		while (true) {
			lock.lock();
			//System.out.println("生产者：进入仓库准备工作...");
			try {
				// 如果满了，则通知消费然后等着不满
				if (size == nums.length) {
					System.out.println("满了，再雇点消费者吧");
					notFull.await();
				}

				Random r = new Random(100);
				nums[nextProducerIdx] = r.nextInt();
				System.out.printf("生产者：nextProducerIdx = %s,size = %s,content = %s\n", nextProducerIdx, size,
						nums[nextProducerIdx]);
				nextProducerIdx = ++nextProducerIdx % nums.length;
				size++;
				notEmpty.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			doSleep(2);
		}
	}

	private void doSleep(int time) {
		try {
			TimeUnit.MINUTES.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ConditionWaitDemo demo = new ConditionWaitDemo();

		Thread t1 = new Thread(demo::consumer);
		Thread t2 = new Thread(demo::producer);

		t1.start();
		t2.start();
	}

}
