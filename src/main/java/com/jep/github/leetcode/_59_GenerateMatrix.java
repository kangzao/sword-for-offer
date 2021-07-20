package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-20 4:15 下午
 */
public class _59_GenerateMatrix {

  public int[][] generateMatrix(int n) {
    int[][] array = new int[n][n];
    int number = 1, sum = n * n;//填充的数量
    int top = 0, bottom = n - 1, left = 0, right = n - 1;
    while (number <= sum) {
      //从左到右
      for (int i = left; i <= right; i++) {
        array[top][i] = number++;
      }
      top++;
      //从上到下
      for (int i = top; i <= bottom; i++) {
        array[i][right] = number++;
      }
      right--;
      //从右到左
      for (int i = right; i >= left; i--) {
        array[bottom][i] = number++;
      }
      bottom--;
      //从下到上 行变小
      for (int i = bottom; i >= top; i--) {
        array[i][left] = number++;
      }
      left++;
    }
    return array;
  }
}
