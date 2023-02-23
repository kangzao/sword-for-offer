package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-04-29 5:25 下午
 */
public class _938_RangeSumBST {

  // 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
  int sum = 0;

  public int rangeSumBST(TreeNode root, int low, int high) {
    dfs(root, low, high);
    return sum;
  }

  void dfs(TreeNode root, int low, int high) {
    if (root == null) {
      return;
    }
    //缩小检索范围
    if (root.val < low) {
      dfs(root.right, low, high);
    } else if (root.val > high) {
      dfs(root.left, low, high);
    } else {
      //根左右
      sum += root.val;
      dfs(root.left, low, high);
      dfs(root.right, low, high);
    }
  }

}
