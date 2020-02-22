package com.liqiang.algorithm;

import java.util.ArrayDeque;

/**
 * <p>Description: [滑动窗口]https://leetcode-cn.com/problems/sliding-window-maximum/</p>
 * Created on 2019/7/11 10:55
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class SlidingWindowMaximum {
    private ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    private int[] nums;

    /**
     * 暴力求解
     * 时间复杂度NK
     * 空间复杂度N-k+1
     *
     * @param nums
     * @param k
     * @return
     */
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || nums.length < k || nums.length ==1 || k ==1) {
//            return nums;
//        }
//        int[] maxNums = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            for (int j = i; j < i + k - 1; j++) {
//                int max = Math.max(nums[j], nums[j + 1]);
//                if(j>i){
//                    maxNums[i] = Math.max(maxNums[i],max);
//                }else{
//                    maxNums[i] = max;
//                }
//            }
//        }
//        return maxNums;
//    }

    /**
     * 双向队列解决滑动窗口问题
     * 时间复杂度O（N）
     * 空间复杂度O（N）
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 1 || nums.length < k) {
            return nums;
        }
        this.nums = nums;
        int[] outputNum = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            cleanDequeNum(i, k);
            arrayDeque.add(i);
        }
        outputNum[0] = nums[arrayDeque.getFirst()];
        int max;
        for (int i = k; i < nums.length; i++) {
            cleanDequeNum(i, k);
            arrayDeque.add(i);
            outputNum[i - k + 1] = nums[arrayDeque.getFirst()];
        }
        return outputNum;
    }

    /**
     * 动态规划
     * 时间复杂度O(N)
     * 空间复杂度：O(N)
     * 解题思路：
     * 分别从左右两边依次计算最大值，当左右两边整除K时，重新定义起始元素（如果两个K块有重合，如何右边数比左边的大，其实可以不需要右边计算，如果右边比左边小，则需要右边计算）
     * 最后以左边下标i(初始值为0)+k-1起，右边以i起，取左右两边元素最大值
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow11(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 1 || nums.length < k) {
            return nums;
        }
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = nums[0];
        right[length - 1] = nums[length - 1];
        for (int i = 1; i < length; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            int j = length - i - 1;
            if ((j+1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int[] output = new int[length - k + 1];
        for (int i = 0; i < length - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, -1, 5};
        int[] ints = maxSlidingWindow11(nums, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private void cleanDequeNum(int i, int k) {
        if (!arrayDeque.isEmpty() && i - k == arrayDeque.getFirst()) {
            arrayDeque.removeFirst();
        }
        while (!arrayDeque.isEmpty()) {
            if (nums[arrayDeque.getLast()] < nums[i]) {
                arrayDeque.removeLast();
            }
        }
    }
}
