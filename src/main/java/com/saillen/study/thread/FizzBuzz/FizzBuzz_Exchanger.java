package com.saillen.study.thread.FizzBuzz;

import java.util.concurrent.Exchanger;
import java.util.function.IntConsumer;

/**
 * @author : saillen
 * @date: 2020/4/16
 **/
public class FizzBuzz_Exchanger {
    private int n;
    private final Exchanger<Integer> fizzChanger = new Exchanger<>();
    private final Exchanger<Integer> buzzChanger = new Exchanger<>();
    private final Exchanger<Integer> fizzBuzzChanger = new Exchanger<>();

    public FizzBuzz_Exchanger(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            int oldValue = -1;
            oldValue = fizzChanger.exchange(oldValue);
            if (oldValue % 3 == 0) {
                printFizz.run();
            } else {
                System.out.println();
                System.out.println("fizz end");
                break;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            int oldValue = -1;
            oldValue = buzzChanger.exchange(oldValue);
            if (oldValue % 5 == 0) {
                printBuzz.run();
            } else {
                System.out.println();
                System.out.println("buzz end");
                break;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            int oldValue = -1;
            oldValue = buzzChanger.exchange(oldValue);
            if (oldValue % 5 == 0 && oldValue % 3 == 0) {
                printFizzBuzz.run();
            } else {
                System.out.println();
                System.out.println("buzz end");
                break;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            boolean ifDiv3 = n % 3 == 0;
            boolean ifDiv5 = n % 5 == 0;
            if (ifDiv3 && ifDiv5) {
                // 通知 fizzBuzz 运行
                fizzBuzzChanger.exchange(i);
            } else if (ifDiv3) {
                // 通知 fizz 运行
                fizzChanger.exchange(i);
            } else if (ifDiv5) {
                // 通知 buzz 运行
                buzzChanger.exchange(i);
            } else {
                printNumber.accept(i);
            }
        }

        fizzChanger.exchange(-1);
        buzzChanger.exchange(-1);
        fizzBuzzChanger.exchange(-1);


    }
}
