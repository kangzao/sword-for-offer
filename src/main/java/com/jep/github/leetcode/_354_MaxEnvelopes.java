package com.jep.github.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @author: enping.jep
 * @create: 2021-02-24 4:44 下午
 */
public class _354_MaxEnvelopes {

  public int maxEnvelopes(int[][] envelopes) {
    //状态转移公式
    //dp[i] = Math.max(dp[i],dp[j]+1) 其中，j<i envelopes[j] < envelopes[i]
    //信封的顺序可以调整,所以按一定顺序组合后，使用最长子序列算法(LIS)运算即可,先按照第一维升序(长款都必须满足内层的比外层的小)，然后使用LIS
    Arrays.sort(envelopes, new Comparator<int[]>() {
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });
    int[] dp = new int[envelopes.length];
    Arrays.fill(dp, 1);
    int result = 0;
    for (int i = 0; i < envelopes.length; i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }

      }
      result = Math.max(result, dp[i]);
    }
    return result;
  }

  public static void main(String args[]) {
  }


}
