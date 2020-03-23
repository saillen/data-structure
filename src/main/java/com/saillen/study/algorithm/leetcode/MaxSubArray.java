package com.saillen.study.algorithm.leetcode;

/**
 * @author : saillen
 * @date: 2020/3/23
 **/
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], curSum = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            log(curSum);
            maxSum = Math.max(maxSum, curSum);
            //log(maxSum);
        }

        return maxSum;
    }

    private void log(int maxSum) {
        System.out.println(maxSum);
    }

}
