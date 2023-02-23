package com.jep.github.leetcode;

/**
 * @author enping
 * @date 2021/7/21 11:11 下午
 **/
public class _152_MaxProduct {

    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        //dp[i][0]表示最小值，dp[i][1]表示最大值
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        /**
         当 nums[i] > 0 时，由于是乘积关系：
         最大值乘以正数依然是最大值；
         最小值乘以同一个正数依然是最小值；
         当 nums[i] < 0 时，依然是由于乘积关系：
         最大值乘以负数变成了最小值；
         最小值乘以同一个负数变成最大值
         */

        //最大积的可能情况有：元素i自己本身，上一个最大积与i元素累乘，上一个最小积与i元素累乘；
        //与i元素自己进行比较是为了处理i元素之前全都是0的情况；
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][0] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
            }
        }
        int res = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(dp[i][1], res);
        }
        return res;


    }
}
