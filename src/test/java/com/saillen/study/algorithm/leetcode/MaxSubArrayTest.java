package com.saillen.study.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : saillen
 * @date: 2020/3/23
 **/
public class MaxSubArrayTest {

    @Test
    public void maxSubArray() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray array = new MaxSubArray();
        int rs = array.maxSubArray(nums);
        System.out.println(rs);
    }

    @Test
    public void maxSubArrayIndex() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray array = new MaxSubArray();
        int[] rs = array.maxSubArrayIndex(nums);
        System.out.println(Arrays.toString(rs));
    }
}
