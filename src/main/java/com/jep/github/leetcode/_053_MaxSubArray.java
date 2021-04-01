package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-27 2:16 PM
 */
public class _053_MaxSubArray {


  public static int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int sum = nums[0];
    int result = sum;
    for (int i = 1; i < nums.length; i++) {
      if (sum > 0) {
        sum += nums[i];
      } else {
        sum = nums[i];
      }
      result = Math.max(result, sum);
    }
    return result;
  }


  // 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
  // 该子数列由两部分组成：以前一个位置为结束点的最大子数列、该位置的数值。
  // 因为该算法用到了“最佳子结构”（以每个位置为终点的最大子数列都是基于其前一位置的最大子数列计算得出,
  // 该算法可看成动态规划的一个例子。
  // 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
  // 其中(sum[i]记录以a[i]为子序列末端的最大序子列连续和)
  public int maxSubArray_dp(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    int[] dp = new int[n];
    dp[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < n; i++) {
      //子数组的和的最大值，dp[i-1]子数组如果小于0，则nums[i]大，于是从i开始新的子数组
      //dp[i-1]子数组大于0，则dp[i - 1]+nums[i]比nums[i]大，nums[i]加入子数组中
      //以每个位置为终点的最大子数列 都是基于其前一位置的最大子数列计算得出
      dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
      max = Math.max(dp[i], max);
    }
    return max;
  }

  public static void main(String args[]) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] nums1 = {1};
    //  Output: 6
    //  Explanation: [4,-1,2,1] has the largest sum = 6.
    System.out.println(maxSubArray(nums1));

  }
}
