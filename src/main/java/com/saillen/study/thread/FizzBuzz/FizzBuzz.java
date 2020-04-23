package com.saillen.study.thread.FizzBuzz;

import java.util.concurrent.Exchanger;
import java.util.function.IntConsumer;

/**
 * @author : saillen
 * @date: 2020/4/17
 **/
public class FizzBuzz {

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            int i = 0;
            int v = calc(i + 1, 3);
            if (v == -1) {
                break;
            }
            printFizz.run();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            int i = 0;
            int v = calc(i + 1, 3);
            if (v == -1) {
                break;
            }
            printBuzz.run();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            int i = 0;
            int v = calc(i + 1, 1);
            if (v == -1) {
                break;
            }
            printFizzBuzz.run();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            int i = 0;
            int v = calc(i + 1, 4);
            if (v == -1) {
                break;
            }
            printNumber.accept(v);
        }
    }


    public int calc(int i, int x) {
        for (; i <= n; i++) {
            boolean ifDiv3 = n % 3 == 0;
            boolean ifDiv5 = n % 5 == 0;
            if (ifDiv3 && ifDiv5 && x == 1) {
                // 通知 fizzBuzz 运行
                return i;
            } else if (ifDiv3 && x == 3) {
                // 通知 fizz 运行
                return i;
            } else if (ifDiv5 && x == 2) {
                // 通知 buzz 运行
                return i;
            } else if (x == 4) {
                return i;
            }
        }
        return -1;
    }

}
