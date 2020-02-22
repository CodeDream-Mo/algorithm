package com.liqiang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: [四数之和等于指定数]</p>
 * https://leetcode-cn.com/problems/4sum/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class FourSum {
    /**
     * 与三数相和类似，只是外层多套了一层
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 4) {
            return resultList;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int L = j + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[R] + nums[L];
                    if (sum == target) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[R], nums[L]));
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        R--;
                        L++;
                    } else if (sum < target) {
                        L++;
                    } else if (sum > target) {
                        R--;
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -5, -5, -3, 2, 5, 0, 4};
        List<List<Integer>> lists = fourSum(nums, 0);
    }
}
