package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-08-25 3:06 下午
 */
public class _74_SearchMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = 0;
    int n = matrix[0].length - 1;
    while (m < matrix.length && n >= 0) {
      if (matrix[m][n] == target) {
        return true;
      } else if (matrix[m][n] > target) {
        n--;
      } else {
        m++;
      }
    }
    return false;

  }
}
