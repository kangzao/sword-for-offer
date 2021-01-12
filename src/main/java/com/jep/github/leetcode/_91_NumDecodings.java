package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-12 3:08 下午
 */
public class _91_NumDecodings {


  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    char[] array = s.toCharArray();
    //定义dp[i]为前i个数字的解码数量
    int[] dp = new int[s.length() + 1];
    //初始化
    dp[1] = dp[0] = 1;
    //第i-1个当做一个字符，则dp[i] = dp[i-1]
    for (int i = 2; i <= s.length(); i++) {
      if (array[i - 1] > '0' && array[i - 1] < '9') {
        dp[i] = dp[i - 1];
      }

      if (array[i - 2] != '0' && (array[i - 2] - '0') * 10 + (array[i - 1] - '0') <= 26) {
        dp[i] += dp[i - 2];
      }

    }
    return dp[s.length()];

  }

  public static void main(String args[]) {
    _91_NumDecodings solution = new _91_NumDecodings();
    System.out.println(solution.numDecodings("226"));
    System.out.println(('2' - '0') * 10);

  }


}
