package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-07-16 7:58 下午
 */
public class _78_Subsets {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    backTrack(nums, 0, new ArrayList());
    return res;


  }

  //index表示选择时的索引位置
  public void backTrack(int[] nums, int index, List<Integer> list) {
    res.add(new ArrayList(list));
    for (int i = index; i < nums.length; i++) {
      list.add(nums[i]);
      backTrack(nums, i + 1, list);
      list.remove(list.size() - 1);
    }
  }

}
