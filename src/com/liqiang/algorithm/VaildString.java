package com.liqiang.algorithm;

import java.util.Stack;

/**
 * <p>Description: [校验字符串是否有效]</p>
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class VaildString {
    /**
     * 时间复杂度最大O(N)
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char str = chars[i];
            if(str == '{' || str == '(' || str == '['){
                stack.push(str);
            }else if(str == '}' || str == ')' || str == ']'){
                if(stack.isEmpty()){
                    return  false;
                }
                if(swapChar((char)stack.pop()) != str){
                    return false;
                }

            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    private char swapChar(char left){
        switch (left){
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                return '0';
        }
    }

}
