package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-15 4:02 下午
 */
public class _718_FindLength {
  /**
   dp[i][j] ：长度为i，末尾项为A[i-1]的子数组，与长度为j，末尾项为B[j-1]的子数组，二者的最大公共后缀子数组长度。
   如果 A[i-1] != B[j-1]， 有 dp[i][j] = 0
   如果 A[i-1] == B[j-1]， 有 dp[i][j] = dp[i-1][j-1] + 1

         3  2  1  4  7

      0  0  0  0  0  0

   1	0  0  0  1  0  0

   2	0  0  1  0  0  0

   3	0  1  0  0  0  0

   2	0  0  2  0  0  0

   1	0  0  0	 3	0  0

   base case：如果i == 0||j == 0，则二者没有公共部分，dp[i][j]=0
   */

  public int findLength(int[] nums1, int[] nums2) {
    int m = nums1.length,n = nums2.length;
    int[][] dp = new int[m + 1][n + 1];
    int res = 0;
    for(int i = 1; i <= m; i++){
      for(int j = 1; j <= n; j++){
        if(nums1[i - 1] == nums2[j - 1]){
          dp[i][j] = dp[i-1][j-1] + 1;
        }
        res = Math.max(res,dp[i][j]);
      }

    }
    return res;
  }

}
