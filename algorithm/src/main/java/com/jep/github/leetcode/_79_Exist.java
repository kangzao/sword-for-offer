package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-19 4:57 下午
 */
public class _79_Exist {


  public boolean exist(char[][] board, String word) {
    int m = board.length, n = board[0].length;
    if (m == 0 || n == 0) {
      return false;
    }
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dfs(board, word, 0, visited, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  //四个方向寻找字符，中间过程只要找不到，就返回false，全部找到返回true
  public boolean dfs(char[][] board, String word, int index, boolean[][] visited, int row,
      int col) {

    if (index == word.length()) {
      return true;
    }
    //边界外 已经遍历过了
    if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
      return false;
    }

    if (word.charAt(index) != board[row][col] || visited[row][col]) {
      return false;
    }

    visited[row][col] = true;

    boolean result = dfs(board, word, index + 1, visited, row - 1, col) ||
        dfs(board, word, index + 1, visited, row + 1, col) || dfs(board, word, index + 1, visited,
        row, col - 1)
        || dfs(board, word, index + 1, visited, row, col + 1);

    visited[row][col] = false;

    return result;


  }
}
