package com.saillen.study.algorithm.sorted;

/**
 * @author : saillen
 * @date: 2020/4/29
 **/
public class BubbleSort {

    public int[] sort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
        return nums;
    }
}
