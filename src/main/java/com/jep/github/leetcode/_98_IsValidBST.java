package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-05 3:43 下午
 */
public class _98_IsValidBST {

  public boolean isValidBST(TreeNode root) {

    return isValidBST(root, null, null);
  }

  public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    // base case
    if (root == null) {
      return true;
    }
    if (min != null && root.val <= min.val) {
      return false;
    }

    if (max != null && root.val >= max.val) {
      return false;
    }

    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
  }

}
