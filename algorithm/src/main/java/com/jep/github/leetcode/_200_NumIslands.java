package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-26 9:23 上午
 */
public class _200_NumIslands {

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public void dfs(char[][] grid, int i, int j) {
    int m = grid.length, n = grid[0].length;
    //边界值
    if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i + 1, j);
    dfs(grid, i - 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
  }


}
