package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-26 10:19 上午
 */
public class _54_SpiralOrder {

  public List<Integer> spiralOrder(int[][] matrix) {

    int left = 0, up = 0, right = matrix[0].length - 1, down = matrix.length - 1;
    List<Integer> list = new ArrayList<>();

    while (true) {
      //从左往右 行不变 列变 left增大
      for (int i = left; i <= right; i++) {
        list.add(matrix[up][i]);
      }
      up++;
      //for循环不满足的时候，up++仍然被执行，此时要判断up的越界问题 其他几个方向也是类似的
      if (up > down) {
        break;
      }

      //从上往下 行变 列不变 up增大
      for (int i = up; i <= down; i++) {
        list.add(matrix[i][right]);

      }
      right--;
      if (right < left) {
        break;
      }
      //从右往左 列变 行不变  right减小
      for (int i = right; i >= left; i--) {
        list.add(matrix[down][i]);

      }
      down--;
      if (down < up) {
        break;
      }

      //从下往上 行减小 列不变
      for (int i = down; i >= up; i--) {
        list.add(matrix[i][left]);
      }
      left++;
      if (left > right) {
        break;
      }
    }
    return list;
  }

}
