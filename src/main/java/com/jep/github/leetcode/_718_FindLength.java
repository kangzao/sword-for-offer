package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-15 4:02 下午
 */
public class _718_FindLength {

  public int findLength(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    int result = Integer.MIN_VALUE;
    //动态转移方程 dp[i][j] = dp[i - 1][j - 1] + 1
    //初始化数组,长度为i，末尾项为A[i-1]的子数组，与长度为j，末尾项为B[j-1]的子数组，二者的最大公共后缀子数组长度
    int[][] dp = new int[m + 1][n + 1];
    dp[0][0] = 0;//badcase 当比较对象长度为0
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(result, dp[i][j]);
        }
      }
    }
    return result == Integer.MIN_VALUE ? 0 : result;
  }

}
