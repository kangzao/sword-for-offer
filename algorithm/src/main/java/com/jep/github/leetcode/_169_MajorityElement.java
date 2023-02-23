package com.jep.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2021-04-19 4:15 下午
 */
public class _169_MajorityElement {

  public int majorityElement(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num : nums) {
      int count = map.getOrDefault(num, 0);
      if (count >= n / 2) {
        return num;
      } else {
        map.put(num, count + 1);
      }
    }
    return -1;
  }

}
