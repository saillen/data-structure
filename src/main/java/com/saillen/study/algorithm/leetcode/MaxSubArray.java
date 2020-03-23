package com.saillen.study.algorithm.leetcode;

/**
 * <href>https://leetcode-cn.com/problems/maximum-subarray/</href>
 * 问题：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 题目难度：简单，属于经典问题，面试如问应必会
 * <p>
 * 问题分析：此问题
 * <p>
 * 算法设计：
 * <ul>
 *     <li>贪心思想：</li>
 *     <li>分治思想：</li>
 *     <li>动态规划：</li>
 * </ul>
 *
 * @author : saillen
 * @date: 2020/3/23
 **/
public class MaxSubArray {

    /**
     * 返回某个数列的最大子序列的值
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], curSum = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            //log(curSum);
            maxSum = Math.max(maxSum, curSum);
            //log(maxSum);
        }

        return maxSum;
    }

    /**
     * 变种返回最大子序列的下标
     *
     * @param nums
     * @return
     */
    public int[] maxSubArrayIndex(int[] nums) {
        int maxSum = nums[0], curSum = nums[0];
        int maxI = 0, maxJ = 0, curI = 0, curJ = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            // 新序列的和
            int newSum = curSum + nums[i];
            if (nums[i] < newSum) {
                // 最大子子序列扩大到 nums[i]
                curSum = newSum;
                curJ = i;
            } else {
                // 抛弃前面的序列，从 nums[i] 开始出现了新的最优解
                curSum = nums[i];
                curI = curJ = i;
            }

            // 维护全局最优解
            if (curSum > maxSum) {
                maxI = curI;
                maxJ = curJ;
                maxSum = curSum;
            }
        }
        return new int[]{maxI, maxJ, maxSum};
    }


    private void log(int maxSum) {
        System.out.println(maxSum);
    }

}
