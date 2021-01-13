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

    int row = grid.length;
    int col = grid[0].length;

    int[][] dp = new int[row][col];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < row; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int i = 1; i < col; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
      }
    }
    return dp[row - 1][col - 1];

  }

  public static void main(String args[]) {
    _64_MinPathSum solution = new _64_MinPathSum();
    int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(solution.minPathSum(array));
  }


}
