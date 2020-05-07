package com.saillen.study.algorithm.sorted;

import java.util.Arrays;

/**
 * @author : saillen
 * @date : 2020-04-30
 */
public class BuddleSorted2 {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 3, 2, 1 };
        nums = sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sort(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return nums;
        }

        int length = nums.length;
        // 外层控制要找多少次，比如 第一次 5 到最后了，那还要控制把 4 放到最后
        for(int i = 0; i < length; i++) {
            // 内层把最小的放到最前面去
            for(int j = length - 1; j > i; j--) {
                if(nums[j] < nums[j - 1]) {
                    sweep(nums, j, j - 1);
                }
            }
        }

        return nums;
    }

    public static void sweep(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
