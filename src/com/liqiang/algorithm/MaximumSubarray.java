package com.liqiang.algorithm;
/**
 * <p>Description: [最大子序和]</p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 * Created on 2019/7/11 16:32
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class MaximumSubarray {
    /**
     * 暴力解法
     * 时间复杂度(ON)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int ans =nums[0];
        int sum = 0;
        for(int num : nums){
            if(sum >0){
                sum =sum+num;
            }else{
                sum = num;
            }
            ans = Math.max(ans ,sum);
        }
        return ans;
    }

    /**
     * sort排序再添加
     */

    /**
     * 分治
     */



}
