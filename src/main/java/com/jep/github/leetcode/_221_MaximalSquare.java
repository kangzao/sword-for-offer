package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-08-02 10:07 上午
 */
public class _221_MaximalSquare {

  public int maximalSquare(char[][] matrix) {
    int res = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    //dp[i][j]表示以i,j作为右下角坐标的正方形的最大边长
    //左、上、左上三个方向移动一格的最小值 + 当前格子(记住就好)
    //dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1],dp[i - 1][j - 1]) + 1;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
          res = Math.max(res, dp[i + 1][j + 1]);
        }
      }
    }
    return res * res;
  }

}
