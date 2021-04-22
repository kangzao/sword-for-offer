package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2021-04-22 7:45 下午
 */
public class _29_SpiralOrder {


  public int[] spiralOrder(int[][] matrix) {
    if (matrix.length == 0) {
      return new int[0];
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int[] res = new int[m * n];
    int left = 0, right = n - 1, up = 0, down = m - 1, x = 0;
    while (true) {
      //从左往右
      for (int i = left; i <= right; i++) {
        res[x++] = matrix[up][i];
      }
      //上边界变大
      if (++up > down) {
        break;
      }
      //从上往下
      for (int i = up; i <= down; i++) {
        res[x++] = matrix[i][right];
      }
      //右边界需要改变，右边界变小
      if (--right < left) {
        break;
      }
      //从右往左
      for (int i = right; i >= left; i--) {
        res[x++] = matrix[down][i];
      }
      //下边界需要被改变，下边界变小
      if (--down < up) {
        break;
      }
      //从下往上
      for (int i = down; i >= up; i--) {
        res[x++] = matrix[i][left];
      }
      //左边界有变化,变大
      if (++left > right) {
        break;
      }

    }
    return res;
  }
}

