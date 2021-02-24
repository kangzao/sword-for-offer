package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-02-02 10:04 上午
 *
 *
 */
public class _188_MaxProfit {

  public int maxProfit(int k, int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int[][][] dp = new int[prices.length][k + 1][2];
    //状态转移方程
    //第i天的第j次交易持股
    //dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i])
    //第i天的第j次交易不持股
    //dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i])
    //一次交易包含买入和卖出，实际的交易次数 = prices.length/2，如果给定的交易次数大于实际交易次数，则按照实际交易次数
    int trades = Math.min(prices.length / 2, k);

    //初始化第0天的第i次交易的情况
    for (int i = 0; i <= trades; i++) {
      //第0天持股
      dp[0][i][1] = -prices[0];
      //第0天不持股，数组初始化的时候就是0，这行代码可以不要
      dp[0][i][0] = 0;

    }

    for (int i = 1; i < prices.length; i++) {
      for (int j = 1; j <= trades; j++) {
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
      }
    }
    return dp[prices.length - 1][trades][0];
  }

}
