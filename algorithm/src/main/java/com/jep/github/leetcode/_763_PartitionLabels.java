package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-07-28 2:42 PM
 */
public class _763_PartitionLabels {

  public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    //记录每个字符最后出现的位置
    for (int i = 0; i < s.length(); i++) {
      last[s.charAt(i) - 'a'] = i;
    }
    //每个分段的起始位置
    int start = 0, end = 0;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      end = Math.max(end, last[s.charAt(i) - 'a']);
      if (i == end) {
        result.add(end - start + 1);
        start = end + 1;
      }

    }
    return result;
  }

  public static void main(String args[]) {

  }

}
