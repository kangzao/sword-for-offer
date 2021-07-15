package com.jep.github.leetcode;

/**
 * @author enping
 * @date 2021/7/15 9:44 下午
 **/
public class _695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    //返回每个坐标的最大面积
    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;//防止重复遍历
        int number = 1;//当前这个值肯定是1
        number += dfs(grid, i + 1, j);//up
        number += dfs(grid, i - 1, j);//down
        number += dfs(grid, i, j - 1);//left
        number += dfs(grid, i, j + 1);//right
        return number;
    }
}
