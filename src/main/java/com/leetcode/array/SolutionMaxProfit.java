package com.leetcode.array;

/**
 * @description:maxProfit
 * @author:zyg
 * @time:2021/6/24 下午 11:43
 */
public class SolutionMaxProfit {
    public static void main(String[] args) {
        int[] prices = {1, 5, 2, 9, 2, 3, 91};
        maxProfit(prices);
    }

    /**
     * 1,再一次购入股票前,必须把前一次的股票卖出
     * 2,profit最大化:后一天价格>前一天就买入+,后一天<=前一天不操作0,操作-
     * 即只要后一天价格大于前一天就买入,否则不操作.
     * @param prices
     */
    public static void maxProfit(int[] prices) {
        int days = prices.length;
        int profit = 0;
        for (int i = 0; i < days-1; i++) {
            if (prices[i] < prices[i+1]) {
                profit += prices[i+1] - prices[i];
            }
        }
        System.out.println("最大利益为:" + profit);
    }
}
