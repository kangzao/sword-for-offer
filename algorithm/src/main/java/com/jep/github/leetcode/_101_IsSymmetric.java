package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-08 4:41 下午
 * 2022年06月13日14:59:26
 */
public class _101_IsSymmetric {

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    if (left.val != right.val) {
      return false;
    }
    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

  }

}
