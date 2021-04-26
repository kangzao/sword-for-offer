package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-26 10:19 上午
 */
public class _54_SpiralOrder {

  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return null;
    }

    int down = matrix.length - 1, right = matrix[0].length - 1, left = 0, up = 0;
    List<Integer> res = new ArrayList<>((down + 1) * (right + 1));
    while (left <= right && up <= down) {
      //left to right
      for (int i = 0; i <= right; i++) {
        res.add(matrix[up][i]);
      }
      up++;
      //up to down
      for (int i = up; i <= down; i++) {
        res.add(matrix[right][i]);
      }
      right--;
      //right to left
      for (int i = right; i >= left; i--) {
        res.add(matrix[down][i]);
      }
      down--;
      //down to up
      for (int i = down; i >= up; i--) {
        res.add(matrix[down][i]);
      }
      left++;
    }
    return res;

  }

}
