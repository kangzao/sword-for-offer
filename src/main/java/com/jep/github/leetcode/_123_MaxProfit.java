package com.jep.github.leetcode;

/**
 * @author enping
 * @date 2021/1/30 下午10:26
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/
 **/
public class _123_MaxProfit {

  public int maxProfit(int[] prices) {
    //定义数组和状态
    //前i天的最大收益，有五种状态：0-无交易 1-第一次买入 2-第一次卖出 3-第二次买入 4-第二次卖出
    int[][] dp = new int[prices.length][5];
    //初始化
    //第0天无交易
    dp[0][0] = 0;
    //第0天第一次买入
    dp[0][1] = -prices[0];
    //第0第一次卖出 当天买入又卖出
    dp[0][2] = 0;
    //第0天第二次买入
    dp[0][3] = -prices[0];
    //第0天第二次卖出
    dp[0][4] = 0;
    //循环 递推公式
    for (int i = 1; i < prices.length; i++) {
      dp[i][0] = dp[i - 1][0];
      //第一次买入
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
      //第一次卖出
      dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
      //第二次买入
      dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
      //第二次卖出
      dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
    }

    return dp[prices.length - 1][4];
  }


  public static void main(String args[]) {

  }
}
