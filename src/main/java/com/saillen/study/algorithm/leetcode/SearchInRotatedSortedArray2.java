package com.saillen.study.algorithm.leetcode;


import java.nio.IntBuffer;

/**
 * @author : saillen
 * @date: 2020/4/27
 **/
public class SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 1, 2};
        //int[] nums = new int[]{3, 1};
        System.out.println(searchMinValue(nums));

    }

    private static int searchMinValue2(int[] nums) {
        int minValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
        }
        return minValue;
    }

    private static int searchMinValue(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int left = 0, right = length - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            // 0 到 middle 是有序的
            if (nums[0] < nums[middle]) {
                // 确定是否是最小数组
                if (nums[0] < nums[middle + 1] && nums[0] < nums[length - 1]) {
                    return nums[0];
                } else {
                    left = middle + 1;
                }
            } else {
                // 另外一半是有序的
                if (nums[middle] < nums[0] && nums[middle] < nums[middle - 1]) {
                    return nums[middle];
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
