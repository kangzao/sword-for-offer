package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-09 3:05 下午
 */
public class _112_HasPathSum {

  /**
   * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ， 判断该树中是否存在 根节点到叶子节点 的路径， 这条路径上所有节点值相加等于目标和targetSum 。
   **/


  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return root.val == targetSum;
    }
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
        targetSum - root.val);

  }

}
