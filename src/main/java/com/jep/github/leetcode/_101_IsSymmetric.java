package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-08 4:41 下午
 */
public class _101_IsSymmetric {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    return compare(left, right);
  }

  public boolean compare(TreeNode left, TreeNode right) {
    if (left == null || right == null) {
      return right == left;
    }

    if (left.val != right.val) {
      return false;
    }
    return compare(left.left, right.right) && compare(left.right, right.left);
  }

}
