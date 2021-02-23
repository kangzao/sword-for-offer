package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-23 9:01 AM
 * https://leetcode-cn.com/circle/article/qiAgHn/
 */
public class _121_MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }

    //动态规划
    public int maxProfit_dp(int[] prices) {
        int[][] dp = new int[prices.length][2];
        //状态转移方程
        // dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]) 第i天没有持股
        // dp[i][1] = Math.max(dp[i-1][1],-prices[i]) 第i天持股，由于只能交易一次，买入没有状态变化，既然买入了，则利润为-prices[i]
        // 最终要的结果是dp[prices.length-1][0]
        //定义初始值
        dp[0][0] = 0; //第0天不持股，利润为0
        dp[0][1] = -prices[0];
        //循环
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String args[]) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
