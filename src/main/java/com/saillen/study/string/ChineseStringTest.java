package com.saillen.study.string;

/**
 * char 是 2 字节<br>
 * char 可以存下一个汉字
 *
 * @author : saillen
 * @date: 2020/4/30
 **/
public class ChineseStringTest {
    public static void main(String[] args) {
        String str = "我是中国人";
        char c = str.charAt(2);
        System.out.println(c);
    }
}
