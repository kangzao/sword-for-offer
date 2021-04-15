package com.jep.github.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-15 5:15 下午
 */
public class _350_Intersect {

  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> result = new LinkedList();
    //建立hash表存放数组和对应的出现次数，从最小的数组开始
    if (nums1.length > nums2.length) {
      intersect(nums2, nums1);
    }
    //初始化hash表
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums1.length; i++) {
      int count = map.getOrDefault(nums1[i], 0) + 1;
      map.put(nums1[i], count);
    }
    //按照最长的数组初始化
    int[] intersection = new int[nums1.length];
    int index = 0;
    //然后遍历第二个数组，如果在hash表中存在，则记录到结果中，hash表中的出现次数减一
    for (int i = 0; i < nums2.length; i++) {
      //数组1中的出现次数
      int count = map.getOrDefault(nums2[i], 0);
      if (count > 0) {
        intersection[index++] = nums2[i];
        count--;
        if (count > 0) {
          map.put(nums2[i], count);
        } else {
          map.remove(nums2[i]);
        }
      }
    }
    return Arrays.copyOfRange(intersection, 0, index);
  }

}
