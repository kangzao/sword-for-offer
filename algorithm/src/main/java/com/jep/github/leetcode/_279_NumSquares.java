package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-02-25 10:54 上午
 */
public class _279_NumSquares {

  public int numSquares(int n) {
    //状态转移方程 dp[i] = Math.min(dp[i],dp[i-j*j]+1);
    //j*j表示最后一个完全平方数
    int[] dp = new int[n + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = i;//初始化，求最小值，初始化成最坏情况：i由i个完全平方数1组成
      for (int j = 1; i - j * j >= 0; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    return dp[n];
  }

}
