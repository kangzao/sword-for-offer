package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-11 4:31 下午
 *
 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

 */
public class _55_CanJump {

  public boolean canJump_dp(int[] nums) {
    //确定状态 前一个位置为i，终点为j
    //转移方程  j <= i + nums[i] && dp[i] 才能确保可以到达j
    //初始条件和边界情况
    int length = nums.length;
    //dp表示对应的位置是否可达
    boolean[] dp = new boolean[length];
    dp[0] = true;
    //从i跳到j
    for (int j = 1; j < length; j++) {
      for (int i = 0; i < j; i++) {
        if (dp[i] && i + nums[i] >= j) {
          dp[j] = true;
          break;
        }
      }
    }
    return dp[length - 1];
  }

  public boolean canJump(int[] nums) {
    int k = 0;//前n-1个元素能够到达的最远位置
    for (int i = 0; i <= k; i++) {
      //更新最远位置
      k = Math.max(k, i + nums[i]);
      //如果最远位置大于或者等于最远端的位置
      if (k >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }

}
