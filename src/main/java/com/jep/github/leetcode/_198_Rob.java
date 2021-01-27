package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-22 9:35 上午
 * 输入：[2,7,9,3,1]
  输出：12
  解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
  偷窃到的最高金额 = 2 + 9 + 1 = 12 。

 */
public class _198_Rob {

  //分两种情况，不选x时是f(x-1),如果选了是f(x-2)+nums[x]，因此f(x) = Math.max(f(x-1),f(x-2)+nums[x-1])
  //这里是x-1，因为dp[i]计算的是前N个元素经过选择后的最大值，前N个元素的最后一个元素的索引位置是i-1
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    //[2,7,9,3,1]
    //dp[i]代表前N个元素经过选择后的最大值
    for (int i = 2; i <= nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
    }

    return dp[nums.length];

  }

  public static void main(String args[]) {
    _198_Rob solution = new _198_Rob();
    int nums[] = {1, 2, 3, 1};
    System.out.println(solution.rob(nums));

  }

}
