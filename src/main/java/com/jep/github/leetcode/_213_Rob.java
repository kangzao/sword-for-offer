package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-27 11:10 上午
 */
public class _213_Rob {

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    //[2,7,9,3,1]
    //dp[i]代表前N个元素经过选择后的最大值
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
    }

    return dp[nums.length];
  }

  public static void main(String args[]) {

  }

}
