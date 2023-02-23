package com.jep.github.swordForOffer;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-22 7:45 下午
 */
public class _29_SpiralOrder {


  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return null;
    }

    int down = matrix.length - 1, right = matrix[0].length - 1, left = 0, up = 0;
    List<Integer> res = new ArrayList<>((down + 1) * (right + 1));
    while (true) {
      //left to right
      for (int i = left; i <= right; i++) {
        res.add(matrix[up][i]);
      }
      if (++up > down) {
        break;
      }

      //up to down
      for (int i = up; i <= down; i++) {
        res.add(matrix[i][right]);
      }
      if (--right < left) {
        break;
      }
      //right to left
      for (int i = right; i >= left; i--) {
        res.add(matrix[down][i]);
      }
      if (--down < up) {
        break;
      }
      //down to up
      for (int i = down; i >= up; i--) {
        res.add(matrix[i][left]);
      }
      if (++left > right) {
        break;
      }
    }
    return res;
  }
}

