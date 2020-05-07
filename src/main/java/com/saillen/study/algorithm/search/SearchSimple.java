package com.saillen.study.algorithm.search;

/**
 * @author : saillen
 * @date : 2020-04-30
 */
public class SearchSimple {

    public static int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }

        if(nums.length == 1) {
            return nums[0] == target ? nums[0] : -1;
        }

        int length = nums.length;
        int maxIdx = -1;
        for(int i = 0; i < length; i++) {
            if(nums[i] == target) {
                return maxIdx;
            }
        }

        return maxIdx;

    }
}
