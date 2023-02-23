package com.jep.github.leetcode;

import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2020-07-21 2:36 PM
 */
public class _455_FindContentChildren {


  public static int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);

    int gItem = 0, sItem = 0;
    while (gItem < g.length && sItem < s.length) {
      if (s[sItem] >= g[gItem]) {
        sItem++;
        gItem++;
      } else {
        sItem++;
      }
    }
    return gItem;
  }


  public static void main(String args[]) {
    int a[] = {1, 2};
    int b[] = {1, 2, 3};
    System.out.println(findContentChildren(a, b));

//    [1,2,3], [1,1]  1
//    [1,2], [1,2,3]  2
  }

}
