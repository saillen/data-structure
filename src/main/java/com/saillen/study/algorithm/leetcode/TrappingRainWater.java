package com.saillen.study.algorithm.leetcode;

/**
 * @author : saillen
 * @date: 2020/4/4
 **/
public class TrappingRainWater {

    public static void main(String[] args) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        // int[] height = new int[]{4, 2, 3};
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int rs = new TrappingRainWater().trap(height);
        System.out.print(rs);
    }

    public int trap(int[] height) {
        // 分治：分解为 n 给子集。
        // 最优子结构：left <= right 的子集，合并所有子集求解

        // 分解问题
        int size = height.length;
        int sum = 0;

        for (int i = 0; i < size; ) {
            // 找到子问题：left 的柱子高度最少是 1
            if (height[i] <= 0) {
                i++;
                continue;
            }
            // left 有了，找right，第一个不为 0 的
            boolean ifChangeIdx = false;
            for (int j = i + 1; j < size; j++) {
                if (height[j] <= 0) {
                    continue;
                }
                // 求解子问题，并合并子问题解
                int subSum = calcSubTrap(height, i, j);
                if (subSum > 0) {
                    // 合并子问题解，并跳出到下一个子问题
                    sum += subSum;
                    i = j;
                    ifChangeIdx = true;
                    break;
                }
            }
            if (!ifChangeIdx) {
                i++;
            }
        }
        return sum;
    }

    private int calcSubTrap(int[] height, int left, int right) {
        // 判断

        // 假设中间都是 0 ，则容量是 (right - left) * Math.min(height[left],height[right]);
        // 去掉中间  height[left] > 0 的,
        int minHeight = Math.min(height[left], height[right]);
        int sum = (right - left - 1) * minHeight;
        for (int i = left + 1; i < right; i++) {
            if (height[i] > 0) {
                sum = sum - Math.min(minHeight, height[i]);
            }
        }
        return Math.max(sum, 0);
    }

}
