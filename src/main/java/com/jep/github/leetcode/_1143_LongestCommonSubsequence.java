package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-08-05 7:08 下午
 */
public class _1143_LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {
    //如果第和第j位相同 dp[i][j] =  dp[i - 1][j - 1] + 1
    //不相同：dp[i][j] =
    //text1的前i个元素和text2的前j个元素的最长公共子序列
    // 求dp[m][n]
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }

      }
    }
    return dp[m][n];

  }

}
