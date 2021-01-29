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
    int[][] dp = new int[prices.length][2];
    dp[0][0]
    //当天没有持股，则前一天可以持股，也可以不持股：
    //如果前一天持股，dp[i][0] = dp[i-1][1] + prices[i]  前一天不持股 dp[i][0] = dp[i-1][0]

    //当天持股
    //前一天持股  dp[i][1] = dp[i-1][1]  前一天不持股 dp[i][1] = dp[i-1][0] - prices[i]
  }

  public static void main(String args[]) {
    int array[] = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(array));

//    [7,1,5,3,6,4] 7
//    [1,2,3,4,5] 4

  }

}
