package com.jep.github.leetcode;

import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2020-10-14 4:53 PM
 */
public class _322_CoinChange {

  /**
   * 动态规划
   */
  public int coinChange_dp(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }


  public static void main(String args[]) {

  }

}
