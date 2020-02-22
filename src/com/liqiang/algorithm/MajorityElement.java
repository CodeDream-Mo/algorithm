package com.liqiang.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: [多数元素求出现次数大于一半数之上的元素]</p>
 * https://leetcode-cn.com/problems/majority-element/
 * Created on 2019/7/11 16:32
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class MajorityElement {
    /**
     * 暴力解法(双重for循环)
     * 时间复杂度:0(N^2)
     * 空间复杂度:0(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int midNum = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > midNum) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * Map解法
     * 时间复杂度:0(N)
     * 空间复杂度:0(N)
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int midNum = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > midNum) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        System.out.println("计数: nums " + Arrays.toString(nums) + "   num : " + num + "  lo:  " + lo + "  hi: " + hi);
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElemeec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        System.out.println("lo :" + lo + "   hi :" + hi);
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElemeec(nums, lo, mid);
        int right = majorityElemeec(nums, mid + 1, hi);
        System.out.println("left: " + left + "    right:   " + right);
        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        System.out.println("leftCount   :" + leftCount + "   rightCount:   " + rightCount);
        return leftCount > rightCount ? left : right;
    }

    /**
     * 分治解法
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        return majorityElemeec(nums, 0, nums.length - 1);
    }

    /**
     * 先sort，再比较解法
     * 时间复杂度:O(NLOGN)
     *
     * @param nums
     * @return
     */
    public int majorityElement4(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > mid) {
                    return nums[i];
                }
            } else {
                count = 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {12, 20, 30, 12, 12, 30, 20, 20, 20, 20, 20, 20, 30};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement1(nums));
    }
}
