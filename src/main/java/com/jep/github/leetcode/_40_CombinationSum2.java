package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-07-27 7:40 下午
 *
 *
   给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
   candidates中的每个数字在每个组合中只能使用一次。
   注意：解集不能包含重复的组合。
 */
public class _40_CombinationSum2 {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);//将重复元素放在一起
    List<Integer> path = new ArrayList<>();
    dfs(candidates, path, target, 0, 0);
    return res;
  }

  public void dfs(int[] candidates, List<Integer> path, int target, int sum, int begin) {
    if (sum == target) {
      res.add(new ArrayList<>(path));
      return;
    }
    //循环选定一个元素
    for (int i = begin; i < candidates.length; i++) {
      if (candidates[i] > target) {
        return;
      }
      //除重
      if (i > begin && candidates[i] == candidates[i - 1]) {
        continue;
      }
      int n = sum + candidates[i];
      //必须是小于等于 因为单个元素可能满足 candidates[i] == target
      if (n <= target) {
        path.add(candidates[i]);
        //递归选择后续的元素
        dfs(candidates, path, target, n, i + 1);
        path.remove(path.size() - 1);
      }
    }
  }

}
