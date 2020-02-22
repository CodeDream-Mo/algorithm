package com.liqiang.algorithm.greedy;

import java.util.Arrays;

/**
 * <p>Description: [分发饼干]</p>
 * https://leetcode-cn.com/problems/assign-cookies/submissions/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class AssignCookies {
    /**
     * 先排序后贪心
     * 时间复杂度:O(NLOGN)
     * 空间复杂度:O1
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i =0;
        for(int j = 0;j<s.length && i<g.length ;j++){
            if(s[j] >= g[i]){
                i ++;
            }
        }
        return i;
    }
}
