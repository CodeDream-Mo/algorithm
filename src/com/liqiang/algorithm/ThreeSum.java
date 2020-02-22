package com.liqiang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>Description: [三数之和等于0]</p>
 * https://leetcode-cn.com/problems/two-sum/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class ThreeSum {
    /**
     * 这种方式效率比较低，因为每个数都会循环一遍
     * 时间复杂度:O(n2)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultsList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return resultsList;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
//        List<Integer> distinctList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                Integer value = countMap.get(nums[i]);
                countMap.put(nums[i], ++value);
            } else {
                countMap.put(nums[i], 1);
//                distinctList.add(nums[i]);
            }
        }
        if (countMap.get(0) != null && countMap.get(0) >= 3) {
            resultsList.add(Arrays.asList(0, 0, 0));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;

            int j = i + 1;
            if (nums[i] <= 0) {
                while (j < nums.length && nums[j] <= 0) {
                    if (nums[i] == 0 && nums[j] == 0) {
                        j++;
                        continue;
                    }
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        j++;
                        continue;
                    }
                    int differenceNum = 0 - (nums[i] + nums[j]);
                    if (countMap.containsKey(differenceNum)) {
                        resultsList.add(Arrays.asList(nums[i], nums[j], differenceNum));
                    }
                    j++;
                }
            } else {
                while (j < nums.length) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        j++;
                        continue;
                    }
                    int differenceNum = 0 - (nums[i] + nums[j]);
                    if (countMap.containsKey(differenceNum)) {
                        resultsList.add(Arrays.asList(nums[i], nums[j], differenceNum));
                    }
                    j++;
                }
            }
        }
        return resultsList;
    }

    /**
     * 优化ON2，采用移动前后指针方法,这种方式速度优于上面三倍速
     * 1.循环一次，且当出现重复元素nums[i] == nums[i-1]时，重新循环
     * 2.当i+L+R三数相加等于0时，过滤后面元素是否重复
     * 3.当i+L+R三数相加小于0时，则左下标对应的数字需要增大
     * 4.当i+L+R三数相加大于0时，则右下标对应的数字需要减小
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0)
            return resultList;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;//左下标
            int r = nums.length - 1;//右下标
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;//去重
                    while (l < r && nums[r] == nums[r - 1]) r--;//去重
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else if (sum > 0) r--;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] param = {-1, 0, 1};
        threeSum2(param);
    }

}
