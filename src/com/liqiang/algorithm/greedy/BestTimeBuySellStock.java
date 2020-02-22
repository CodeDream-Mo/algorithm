package com.liqiang.algorithm.greedy;

/**
 * <p>Description: [买卖股票的最佳时机 II]</p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Created on 2019/7/29 14:27
 *
 * @author <a href="mailto: liqiang@camelotchina.com">李强</a>
 * @version 1.0
 */
public class BestTimeBuySellStock {
    /**
     * 贪心算法
     * 时间复杂度:ON
     * 空间复杂度:O1
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int price = 0;
        for (int i = 1; i < prices.length; i++) {
            int num = prices[i] - prices[i - 1];
            if (num > 0) {
                price += num;
            }
        }
        return price;
    }

    /**
     * 峰谷法
     * 时间复杂度:ON
     * 空间复杂度:O1
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int start, end;
        int sum = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {//找小
                i++;
            }
            start = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {//找大
                i++;
            }
            end = prices[i];
            sum = sum + (end - start);
        }
        return sum;
    }
}
