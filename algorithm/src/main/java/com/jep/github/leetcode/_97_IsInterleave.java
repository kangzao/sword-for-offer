package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-03-25 8:32 上午
 */
public class _97_IsInterleave {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    //dp[i][j]表示能否用s1的前i位和s2的前j位，交替拼接成s3的前i+j位，转化成子问题：
    //如果最后一位是s1的，则s1的长度大于0，即:i > 0,求dp[i-1][j]
    //如果最后一位是s2的，则j > 0,求dp[i][j-1]
    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
    /**
       最后转换成为求dp[s1.length][s2.length]的值
       由于dp[i][j]依赖于dp[i-1][j]和dp[i][j-1],因此i要从小到大，j也要从小到大计算
       同时初始化时还要考虑dp[0][0] dp[0][j]和dp[i][0]的情况
       dp[0][j]表示能否仅由s2[0...j-1]构成s3[0...j-1];
       dp[i][0]表示能否仅由s1[0....i-1]构成s3[0....i-1];
     **/

    dp[0][0] = true;//空字符串 s1的前0位和s2的前0位，可以交替拼接成s3的前0位，即空串
    for (int j = 1; j <= s2.length() && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
      dp[0][j] = true;
    }
    for (int i = 1; i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
      dp[i][0] = true;
    }
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
            || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
      }
    }
    return dp[s1.length()][s2.length()];
  }
}