package com.jep.github.leetcode;

import java.util.HashSet;

/*
 * @author: enping.jep
 * @create: 2021-04-14 12:08 下午
 */
public class _349_Intersection {

  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet(), intersect = new HashSet();
    for (int i = 0; i < nums1.length; i++) {
      set1.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
      if (set1.contains(nums2[i])) {
        intersect.add(nums2[i]);
      }
    }

    int[] array = new int[intersect.size()];
    int i = 0;
    for (Integer item : intersect) {
      array[i++] = item;
    }
    return array;
  }

}
