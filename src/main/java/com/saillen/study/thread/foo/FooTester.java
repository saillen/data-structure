package com.saillen.study.thread.foo;

/**
 * @author : saillen
 * @date: 2020/4/16
 **/
public class FooTester {
    public static void main(String[] args) throws InterruptedException {
        //Foo_Volatile f = new Foo_Volatile();
        // Foo_Waiter f = new Foo_Waiter();
        //Foo_LockSupport f = new Foo_LockSupport();
        // Foo_ReentrantLock f = new Foo_ReentrantLock();
        Foo_Semaphore f = new Foo_Semaphore();

        Thread t1 = new Thread(() -> {
            try {
                f.first((() -> {
                    System.out.print("1");
                }));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                f.second(() -> {
                    System.out.print("2");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                f.third(() -> {
                    System.out.print("3");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        f.t2 = t2;
//        f.t3 = t3;

        t2.start();
        t3.start();
        t1.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
