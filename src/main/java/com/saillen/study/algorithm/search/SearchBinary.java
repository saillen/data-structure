package com.saillen.study.algorithm.search;

/**
 * @author : saillen
 * @date : 2020-04-30
 */
public class SearchBinary {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        System.out.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) {
            return -1;
        }

        if(length == 1) {
            return nums[0] == target ? nums[0] : -1;
        }

        int left = 0;
        int right = length - 1;
        // 细节 <= 这里一定要有等于
        while(left <= right) {
            int middle = (left + right) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;

    }
}
