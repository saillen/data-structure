package com.saillen.study.algorithm.leetcode;


import java.rmi.server.RMIClassLoader;

/**
 * @author : saillen
 * @date: 2020/4/27
 **/
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
//        System.out.println(search(nums, 0));

        int[] nums = new int[]{3, 1};
        System.out.println(search(nums, 1));

    }

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            if (nums[0] <= nums[middle]) {
                // 0 到 middle 是有序的
                if (nums[0] <= target && nums[middle] >= target) {
                    // 落到了 0 到 middle 之间了
                    right = middle - 1;
                } else {
                    // 落到了 middle 到 right 之间了，middle 到 right 是无序的
                    left = middle + 1;
                }
            } else {
                // 0 到 middle 是无序的，那 middle, length 肯定是有序的
                if (nums[middle] < target && nums[nums.length - 1] >= target) {
                    // 落在了这个区间内
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }


}
