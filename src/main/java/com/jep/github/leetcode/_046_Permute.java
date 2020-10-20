package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;
import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-10-19 4:10 PM
 */
public class _046_Permute {

//  public static List<List<Integer>> permute(int[] nums) {
//    List<List<Integer>> allList = new ArrayList<>();
//    helper(nums, 0, new ArrayList<>(), allList);
//    return allList;
//  }
//
//  public static void helper(int[] nums, int from, List<Integer> cur, List<List<Integer>> allList) {
//    if (cur.size() == nums.length) {
//      allList.add(new ArrayList<Integer>(cur));
//      return;
//    }
//    for (int i = from; i < nums.length; ++i) {
//      swap(nums, from, i);
//      cur.add(nums[from]);
//      helper(nums, from + 1, cur, allList);
//      cur.remove(cur.size() - 1);
//      swap(nums, from, i);
//    }
//  }
//
//  public static void swap(int[] nums, int i, int j) {
//    int temp = nums[i];
//    nums[i] = nums[j];
//    nums[j] = temp;
//  }

  public static List<List<Integer>> permute(int[] nums) {
    int len = nums.length;
    // 使用一个动态数组保存所有可能的全排列
    List<List<Integer>> res = new ArrayList<>();
    if (len == 0) {
      return res;
    }

    boolean[] used = new boolean[len];
    List<Integer> path = new ArrayList<>();

    dfs(nums, len, 0, path, used, res);
    return res;
  }

  private static void dfs(int[] nums, int len, int depth,
      List<Integer> path, boolean[] used,
      List<List<Integer>> res) {

    if (depth == len) {
      res.add(new ArrayList<>(path));
      return;
    }

    // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
    for (int i = 0; i < len; i++) {
      //去重，path里面的值不能一样
      if (!used[i]) {
        path.add(nums[i]);
        used[i] = true;
        System.out.println("递归之前：" + path + ",i=" + i);
        dfs(nums, len, depth + 1, path, used, res);

        // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
        used[i] = false;
        path.remove(path.size() - 1);
        System.out.println("递归之后：" + path + ",i=" + i);
      }
    }
  }


  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> lists = permute(nums);
    System.out.println(lists);
  }

}
