package com.jep.github.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-07-22 9:39 AM
 */
public class _406_ReconstructQueue {


  public static int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
      }
    });

    List<int[]> list = new LinkedList();
    for (int[] arr : people) {
      list.add(arr[1], arr);
    }

    int n = people.length;
    return list.toArray(new int[n][2]);
  }


  public static void main(String args[]) {
    int[][] array = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    reconstructQueue(array);

  }

}
