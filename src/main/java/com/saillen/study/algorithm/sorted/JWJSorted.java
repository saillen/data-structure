package com.saillen.study.algorithm.sorted;

import java.util.Arrays;

import static com.saillen.study.algorithm.sorted.BuddleSorted2.sweep;

/**
 * https://www.cnblogs.com/eniac12/p/5329396.html
 *
 * @author : saillen
 * @date : 2020-04-30
 */
public class JWJSorted {
    public static void main(String[] args) {
        int[] nums = { 5, 4, 3, 2, 1 };
        nums = sort(nums);

        System.out.println(Arrays.toString(nums));

    }

    public static int[] sort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {

            // 先把最大的放到最后去
            // (left,right) 之间没有排序好
            int i = left;
            for(; i < right; i++) {
                if(nums[i] > nums[i + 1]) {
                    sweep(nums, i, i + 1);
                }
            }

            right--;

            for(; i > left; i--) {
                if(nums[i] < nums[i - 1]) {
                    sweep(nums, i, i - 1);
                }
            }
            left++;
        }
        return nums;
    }

}
