package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-08-05 7:08 下午
 */
public class _1143_LongestCommonSubsequence {

  public int longestCommonSubsequence(String text1, String text2) {
    //比如对于本题而言，可以定义 dp[i][j] 表示 text1[0:i-1] 和 text2[0:j-1] 的最长公共子序列。
    //之所以 dp[i][j]的定义不是 text1[0:i] 和 text2[0:j] ，是为了方便当 i = 0 或者 j = 0 的时候，dp[i][j]
    // 表示的为空字符串和另外一个字符串的匹配，这样 dp[i][j]可以初始化为 0
    //如果最后一位相同，则dp[i][j] = dp[i - 1][j - 1] + 1 比如:ac bc 的最长公共子序列为 0 + 1 = 1
    //如果最后一位不同,则dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
    // 比如对于 ace和 bc而言，他们的最长公共子序列的长度等于
    // ① ace 和 b 的最长公共子序列长度0 与 ② ac 和 bc的最长公共子序列长度1 的最大值，即 1。
    int m = text1.length(), n = text2.length();

    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        //说明两个子字符串的最后一位相等，所以最长公共子序列又增加了 1
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    //由于 dp[i][j]的含义是 text1[0:i-1] 和 text2[0:j-1] 的最长公共子序列。我们最终希望求的是 text1 和 text2 的最长公共子序列。
    // 所以需要返回的结果是 i = len(text1) 并且 j = len(text2) 时的 dp[len(text1)][len(text2)]
    return dp[m][n];
  }

}
