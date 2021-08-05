package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-08-05 7:08 下午
 */
public class _1143_LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {
    // dp[i][j] =  Math.max(dp[i - 1][j - 1] + 1,Math.max(dp[i][j - 1],dp[i - 1][j]))
    //text1的前i个元素和text2的前j个元素的最长公共子序列
    // 求dp[m][n]
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    dp[0][0] = 1;
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i][j - 1], dp[i - 1][j]));
        }
      }
    }
    return dp[m][n];

  }

}
