package com.liqiang.algorithm;

import java.util.HashMap;

/**
 * <p>Description: [两数之和]</p>
 * https://leetcode-cn.com/problems/two-sum/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class TwoSum {
    /**
     * 暴力求解双重循环
     * 时间复杂度:O（N2）
     * 空间复杂度:O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((nums[i] + nums[j]) == target) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return new int[2];
    }

    /**
     * hash表处理
     * 时间复杂度:O（1）
     * 空间复杂度:O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums.length == 0) {
            return nums;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = hashMap.get(target - nums[i]);
                result[1] = i;
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }
}
