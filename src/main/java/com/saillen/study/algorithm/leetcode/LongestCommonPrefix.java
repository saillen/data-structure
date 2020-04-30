package com.saillen.study.algorithm.leetcode;

/**
 * @author : saillen
 * @date: 2020/5/1
 **/
public class LongestCommonPrefix {

    public static void main(String[] args) {

//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 2) {
            return ".";
        }

        int left = -1, right = -1;
        for (int i = 0; i < strs[0].length(); i++) {
            boolean ifCommonChar = ifCommonChar(strs, i);
            if (ifCommonChar) {
                if (left < 0) {
                    left = i;
                }
                right = i;
            }
        }

        if (left < 0) {
            return ".";
        }

        return strs[0].substring(left, right + 1);
    }

    private static boolean ifCommonChar(String[] strs, int charIdx) {
        for (int rowIdx = strs.length - 1; rowIdx > 0; rowIdx--) {
            // 判断是否越界
            if (charIdx >= strs[rowIdx].length() || charIdx >= strs[rowIdx - 1].length()) {
                return false;
            }

            // 判断是公共字符
            char c1 = strs[rowIdx].charAt(charIdx);
            char c2 = strs[rowIdx - 1].charAt(charIdx);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

}
