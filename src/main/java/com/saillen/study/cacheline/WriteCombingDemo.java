package com.saillen.study.cacheline;

/**
 * @author : saillen
 * @date: 2020/4/22
 **/
public class WriteCombingDemo {

    private static final int ITERATIONS = Integer.MAX_VALUE;
    private static final int ITEMS = 1 << 24;
    private static final int MASK = ITEMS - 1;

    static byte[] array1 = new byte[ITEMS];
    static byte[] array2 = new byte[ITEMS];
    static byte[] array3 = new byte[ITEMS];
    static byte[] array4 = new byte[ITEMS];
    static byte[] array5 = new byte[ITEMS];
    static byte[] array6 = new byte[ITEMS];

    public static long runCaseOne() {
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0) {
            int idx = i & MASK;
            byte b = (byte) i;
            array1[idx] = b;
            array2[idx] = b;
            array3[idx] = b;
            array4[idx] = b;
            array5[idx] = b;
            array6[idx] = b;
        }
        return System.nanoTime() - start;
    }

    public static long runCaseTwo() {
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0) {
            int idx = i & MASK;
            byte b = (byte) i;
            array1[idx] = b;
            array2[idx] = b;
            array3[idx] = b;
        }

        i = ITERATIONS;
        while (--i != 0) {
            int idx = i & MASK;
            byte b = (byte) i;
            array4[idx] = b;
            array5[idx] = b;
            array6[idx] = b;
        }

        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " SingleLoop duration (ns) = " + runCaseOne());
            System.out.println(i + " SplitLoop  duration (ns) = " + runCaseTwo());
        }
    }

}
