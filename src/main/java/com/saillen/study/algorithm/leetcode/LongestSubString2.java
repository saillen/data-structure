package com.saillen.study.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : saillen
 * @date: 2020/4/30
 **/
public class LongestSubString2 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(longestSubString(str));
    }

    public static int longestSubString(String s) {
        int rs = 0;
        int length = s.length();

        int right = 0;
        int left = 0;
        Set<Character> cSet = new HashSet<>();
        while (left < length && right < length) {
            char c = s.charAt(right);
            // 添加成功就扩大窗口
            if (cSet.add(c)) {
                // 表示 left 到 right 不是重复的串，计算下
                rs = Math.max(rs, right - left + 1);
                right++;
            } else {
                // 不再是重复的元素了，这样就移除掉 a
                // abc 添加 b  就是 bc,下次尝试重新添加 b，不成功移除 b
                cSet.remove(s.charAt(left));
                left++;
            }
        }
        return rs;
    }

}
