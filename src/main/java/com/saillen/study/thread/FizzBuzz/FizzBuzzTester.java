package com.saillen.study.thread.FizzBuzz;

/**
 * @author : saillen
 * @date: 2020/4/16
 **/
public class FizzBuzzTester {

    public static void main(String[] args) throws InterruptedException {
        //FizzBuzz_Exchanger f = new FizzBuzz_Exchanger(15);
        FizzBuzz f = new FizzBuzz(15);

        Thread t1 = new Thread(() -> {
            try {
                f.fizz(() -> {
                    System.out.print("fizz,");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                f.buzz(() -> {
                    System.out.print("buzz,");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        Thread t3 = new Thread(() -> {
            try {
                f.fizzbuzz(() -> {
                    System.out.print("fizzbuzz,");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                f.number(value -> System.out.print(value + ","));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }
}
