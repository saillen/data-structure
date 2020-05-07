package com.saillen.study.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : saillen
 * @date: 2020/4/30
 **/
public class LongestSubString {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(findLongestSubString(str));
    }

    public static int findLongestSubString(String s) {
        int length = s.length();
        int rs = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = ifQniqueStr(s, i, j);
                if (len > 0) {
                    rs = Math.max(rs, len);
                }
            }
        }
        return rs;
    }

    private static int ifQniqueStr(String s, int begin, int end) {
        Set cSet = new HashSet();
        for (int i = begin; i <= end; i++) {
            char c = s.charAt(i);
            if (!cSet.add(c)) {
                return -1;
            }
        }
        return end - begin + 1;
    }

}
