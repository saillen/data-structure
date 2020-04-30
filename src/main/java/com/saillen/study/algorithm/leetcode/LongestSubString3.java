package com.saillen.study.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : saillen
 * @date: 2020/4/30
 **/
public class LongestSubString3 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(longestSubString(str));
    }

    public static int longestSubString(String s) {
        int rs = 0;
        int length = s.length();
        int left = 0;
        int right = 0;

        // key -> character
        // value -> 在字符串中的下标位置
        Map<Character, Integer> map = new HashMap<>();
        while (left < length && right < length) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 存在,那么应该把 left 调到 t 的位置
                int m = map.get(c) + 1;
                left = Math.max(m, left);
            }
            // 维护全局最优解
            rs = Math.max(rs, right - left + 1);
            map.put(c, right);
            right++;
        }
        return rs;
    }

}
