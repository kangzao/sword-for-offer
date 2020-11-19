package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-10-23 4:13 PM
 */
public class _051_SolveNQueens {

  public List<List<String>> solveNQueens(int n) {
    char[][] chess = new char[n][n];
    //初始化棋盘
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        chess[i][j] = '.';
      }
    }

    List<List<String>> res = new ArrayList<>();
    solve(res, chess, 0);
    return res;

  }


  private void solve(List<List<String>> res, char[][] chess, int row) {
    for (int col = 0; col < chess.length; col++) {
      if (valid(row, col, chess)) {
        chess[row][col] = 'Q';
        solve(res, chess, row + 1);
        chess[row][col] = '.';
      }
    }
    List<String> path = new ArrayList();
    for (int i = 0; i < chess.length; i++) {
      path.add(new String(chess[i]));
    }

  }

  private boolean valid(int row, int col, char[][] chess) {
    //正上方不能放
    for (int i = 0; i < col; col--) {
      if (chess[row][i] == 'Q') {
        return false;
      }
    }

    //左上方不能放
    for (; row - 1 >= 0 && col - 1 >= 0; row--, col--) {
      if (chess[row - 1][col - 1] == 'Q') {
        return false;
      }
    }

    //右上方不能放
    for (; row - 1 >= 0 && col + 1 <= chess[0].length; row--, col++) {
      if (chess[row - 1][col + 1] == 'Q') {
        return false;
      }
    }
    return true;
  }
}
