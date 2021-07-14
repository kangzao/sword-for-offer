package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-14 10:12 上午
 */
public class _48_Rotate {

  public void rotate(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    //水平交换
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < n; j++) {
        swap(matrix, i, j, m - i - 1, j);
      }
    }
    //对角线交换
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < i; j++) {
        System.out.println(i + "," + j);
        swap(matrix, i, j, j, i);
      }
    }

  }

  public void swap(int[][] matrix, int a, int b, int c, int d) {
    int tmp = matrix[a][b];
    matrix[a][b] = matrix[c][d];
    matrix[c][d] = tmp;
  }
}
