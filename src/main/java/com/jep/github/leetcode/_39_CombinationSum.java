package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-05-31 3:26 下午
 */
public class _39_CombinationSum {

  List<List<Integer>> res = new ArrayList<>();
  List<Integer> path = new LinkedList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //先将candidates升序排列
    Arrays.sort(candidates);
    dfs(candidates, target, 0);
    return res;
  }

  public void dfs(int[] candidates, int remain, int start) {
    if (0 == remain) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      //数组里的数字已经大于那个需要被凑出来的数字，则直接退出，因为数组由小到大排列
      if (candidates[i] > remain) {
        return;
      }
      //假设一定会选当前数字
      path.add(candidates[i]);

      dfs(candidates, remain - candidates[i], i);

      path.remove(path.size() - 1);
    }
  }

  public static void main(String args[]) {
    int[] array = {2, 3, 6, 7};
    int target = 7;
    _39_CombinationSum combinationSumInstance = new _39_CombinationSum();
    combinationSumInstance.combinationSum(array, target);
  }

}
