package com.liqiang.algorithm;

/**
 * Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @Description 这道题有点坑，当输入值是int负数最大范围时，转成正数则数值有问题(int取值范围是: -2的31次方（-2147483648），2的31次方减一（2147483647）)
 */
public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            return recusion(x, -n);
        }
        return recusion(x, n);
    }

    /**
     * 快速幂（递归）
     * 时间复杂度:log(n)
     * 空间复杂度:log（n）
     * 计算公式:偶数 y*y y为每一层计算的记过，奇数为y*y*x
     * @param x
     * @param n
     * @return
     */
    public double recusion(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = recusion(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * 快速幂（循环）
     * 时间复杂度:log(n)
     * 空间复杂度:log（n）
     * 说明:无论奇偶，i=1都会使最后一次汇聚，该循环模拟了递归操作，下一次循环来处理上一次循环的值
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n) {
        long N = n;
        if (n == 0) {
            return 1.0;
        }
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {//无论N是偶数还是奇数，i都会有奇数的时候，当i为奇数时，来汇聚之前的处理结果
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    /**
     * 暴力解法
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++)
            ans = ans * x;
        return ans;
    }
}
