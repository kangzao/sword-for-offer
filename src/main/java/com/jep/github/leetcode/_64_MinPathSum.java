package com.jep.github.leetcode;

import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2021-01-13 9:50 上午
 *
 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 说明：每次只能向下或者向右移动一步。
 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 输出：7
 解释：因为路径 1→3→1→1→1 的总和最小
 */
public class _64_MinPathSum {

  public int minPathSum(int[][] grid) {
    /**
     131
     151
     421
     */
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];//dp[i][j]表示从左上角移动到grid[i][j]的最短路径
    dp[0][0] = grid[0][0];
    //第一列 只能从上向下
    for (int i = 1; i < m; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    //第一行 只能从左向右
    for (int i = 1; i < n; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        //只能向下或者向右
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[m - 1][n - 1];
  }

  public int minPathSum_rollArray(int[][] grid) {
    int m = grid.length;
    if (m == 0) {
      return 0;
    }
    int n = grid[0].length;
    if (n == 0) {
      return 0;
    }

    int[][] dp = new int[2][n];
    int old, now = 0;
//        dp[i][j] = min{dp[i-1][j],dp[i][j-1]}+grid[i][j]
    for (int i = 0; i < m; i++) {
      old = now;
      now = 1 - now;
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[now][j] = grid[i][j];
          continue;
        }
        int tmp = Integer.MAX_VALUE;
        if (i != 0) {
          tmp = Math.min(tmp, dp[old][j]);
        }

        if (j != 0) {
          tmp = Math.min(tmp, dp[now][j - 1]);
        }
        dp[now][j] = tmp + grid[i][j];
      }
    }
    return dp[now][n - 1];

  }


  public static void main(String args[]) {
    _64_MinPathSum solution = new _64_MinPathSum();
    int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(solution.minPathSum_rollArray(array));
  }


}
