package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2022-06-15 4:35 下午
 */
public class _34_PathSum {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int target) {
    dfs(root, target, new ArrayList<Integer>());
    return res;
  }

  public void dfs(TreeNode root, int target, List<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.val);

    //如果已经到达叶子节点
    if (root.left == null && root.right == null) {
      //到达叶子节点，找到路径
      if (target == root.val) {
        res.add(new ArrayList(path));
      }
    }

    dfs(root.left, target - root.val, path);
    dfs(root.right, target - root.val, path);
    path.remove(path.size() - 1);
  }

}
