package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-03-04 4:07 下午
 */
public class _647_CountSubstrings {

  public int countSubstrings(String s) {
    /**
     状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串
     分三种情况：
     1、单个字符 比如 a,dp[i][j] = true
     2、两个相等的字符,比如aa，则 dp[i][j] = true
     3、超过2个字符，比如:ababa s[i] = s[j]的情况下，还要考虑aba子串是否是回文字符串，因此要看 dp[i+1][j-1] 是不是一个回文串

     dp[i][j]的值依赖于dp[i+1][j-1]
     0  1  2  3  4
     i\j | a  b  b  a  c
     --------------------
     0 a | T  F  F  T  F
     1 b | F  T  T  F  F
     2 b | F  F  T  F  F
     3 a | F  F  F  T  F
     4 c | F  F  F  F  T
     **/
    int n = s.length();
    if (n < 2) {
      return n;
    }
    boolean[][] dp = new boolean[n][n];
    int count = 0;
    //单个字符串
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
      count++;
    }
    //两个字符串
    for (int i = 0; i + 1 < n; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;
        count++;
      }
    }
    //两个以上字符串
    for (int length = 2; length <= n; length++) {
      for (int i = 0; i + length < n; i++) {
        int j = i + length;
        if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
          dp[i][j] = true;
          count++;
        }
      }
    }
    return count;
  }
}