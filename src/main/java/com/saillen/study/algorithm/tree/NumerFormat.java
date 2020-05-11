package com.saillen.study.algorithm.tree;

import java.util.Stack;

/**
 *
 * @author : saillen
 * @date : 2020-05-08
 */
public class NumerFormat {

    public static String fmtNumber(String nums){
        Stack<Character> stack = new Stack<>();
        // 把数据全部入栈，栈顶就是尾巴，
        // 如果是反向 如 123 给的是 321 就用队列
        int length = nums.length();
        for(int i = 0 ; i < length; i++){
            stack.push(nums.charAt(i));
        }

        // 格式化出栈
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(!stack.empty()){
            sb.append(stack.pop());
            cnt++;
            if(cnt == 3){
                sb.append(",");
                cnt = 0;
            }
        }

        if(sb.charAt(sb.length() - 1) == ','){
            sb.deleteCharAt(sb.length() - 1);
        }
        // 要反转回来
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = fmtNumber("124346765865423");
        System.out.println(str);
    }

}
