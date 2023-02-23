package com.jep.github.leetcode;

import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2021-01-07 2:45 下午
 *
   给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
   子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class _300_LengthOfLIS {

  public int lengthOfLIS(int[] nums) {
    //状态转移公式 dp数组保存每步子问题的最优解，dp[i]代表第i个元素的最长上升子序列的长度
    //求解dp[i]时，向前遍历找到比i元素小的j,
    //dp[i] = Math.max(dp[i], dp[j]+1);
    if (nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      result = Math.max(result, dp[i]);
    }
    return result;
  }


  //输入：nums = [0,1,0,3,2,3] 输出：4
  public static void main(String args[]) {

  }


}
