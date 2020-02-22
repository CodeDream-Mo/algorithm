package com.liqiang.algorithm.bfsordfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: [括号生成]</p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 链接：https://leetcode-cn.com/problems/generate-parentheses/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class GenerateParentheses {
    /**
     * 回溯的方法（深度优先）
     * 时间复杂度和空间复杂度过于复杂
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        System.out.println(Arrays.toString(ans.toArray()));
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (close < open) {//控制无效组合产生
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
    }


}
