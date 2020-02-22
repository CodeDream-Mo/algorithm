package com.liqiang.algorithm;

/**
 * 斐波那契数列
 */
public class Fib {
    /**
     * 斐波那契数列
     *
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(9));
    }
}
