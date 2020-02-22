package com.liqiang.algorithm;

import java.util.Arrays;

/**
 * <p>Description: [快速排序(分治)]</p>
 * Created on 2019/7/29 10:55
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class QuickSort {
    /**
     * 快速排序
     * 时间复杂度O(NlogN)
     * @param s
     * @param l
     * @param r
     */
    void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = nums[i];
            while (i < j) {
                //从后往前找最小
                while (i < j && nums[j] >= x) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                }
                //从前往后找最大
                while (i < j && nums[i] < x) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                }
            }
            nums[i] = x;
            //前半段
            quick_sort(nums, l, i - 1);
            //后半段
            quick_sort(nums, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int array[] = {1, 4, -2, 9, 10, -5, -1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }
}
