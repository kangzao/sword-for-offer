package com.jep.github.leetcode;

import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-08-05 9:00 下午
 */
public class _139_WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n + 1];//前n个字符串是否可以被分割成字典中的单词

    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }

}
