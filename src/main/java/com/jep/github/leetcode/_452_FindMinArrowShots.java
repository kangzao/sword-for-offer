package com.jep.github.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @author: enping.jep
 * @create: 2020-07-22 8:55 AM
 */
public class _452_FindMinArrowShots {


  public static int findMinArrowShots(int[][] points) {
    if (points.length == 0) {
      return 0;
    }
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });

    int startEnd = points[0][1];
    int count = 1;
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= startEnd) {
        continue;
      }
      startEnd = points[i][1];
      count++;
    }
    return count;

  }

  public static void main(String args[]) {
    int[][] array = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    System.out.println(findMinArrowShots(array));
  }

}
