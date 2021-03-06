package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-23 9:51 AM
 */
public class _122_MaxProfit {

    //  对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
    //  而 d - a = (d - c) + (c - b) + (b - a) ，因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int choice = prices[i] - prices[i - 1];
            if (choice > 0) {
                profit += choice;
            }
        }
        return profit;
    }

    //分两种情况，一种是当天已经没有股票，一直是当天持有股票
    //dp[i][0]表示前i天的当天没有持有股票 dp[i][1]表示前i天的当天持有股票
    public static int maxProfit_dp(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
//        定义二维数组dp[n][2]：
//
//        dp[i][0]表示第 i 天不持有可获得的最大利润；
//        dp[i][1]表示第 i 天持有可获得的最大利润（注意是第 i 天持有，而不是第 i 天买入）。
//        定义状态转移方程：
//
//        不持有：dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
//
//        对于今天不持有，可以从两个状态转移过来：1. 昨天也不持有；2. 昨天持有，今天卖出。两者取较大值。
//
//        持有：dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
//
//        对于今天持有，可以从两个状态转移过来：1. 昨天也持有；2. 昨天不持有，今天买入。两者取较大值。


        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];


    }

    public static void main(String args[]) {
        int array[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(array));

//    [7,1,5,3,6,4] 7
//    [1,2,3,4,5] 4

    }

}
