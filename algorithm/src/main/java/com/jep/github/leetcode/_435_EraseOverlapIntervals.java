package com.jep.github.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @author: enping.jep
 * @create: 2020-07-21 3:26 PM
 */
public class _435_EraseOverlapIntervals {


  public static int eraseOverlapIntervals(int[][] intervals) {

    if (intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });

    int firstEnd = intervals[0][1];
    int count = 1;
    for (int i = 1; i < intervals.length; i++) {
      int[] interval = intervals[i];

      if (interval[0] >= firstEnd) {
        count++;//连续空间数+1
        firstEnd = interval[1];
      }
    }
    return intervals.length - count;
  }


  public static void main(String args[]) {
    int[][] array = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};

    int[][] array1 = {{1, 2}};
    System.out.println(eraseOverlapIntervals(array1));
  }

}
