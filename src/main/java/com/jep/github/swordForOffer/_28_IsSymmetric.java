package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;

/*
 * @author: enping.jep
 * @create: 2021-04-13 3:11 下午
 */
public class _28_IsSymmetric {

  public boolean isSymmetric(TreeNode root) {
    return root == null ? true : recur(root.left, root.right);
  }

  boolean recur(TreeNode L, TreeNode R) {
    if (L == null && R == null) {
      return true;
    }
    if (L == null || R == null || L.val != R.val) {
      return false;
    }
    return recur(L.left, R.right) && recur(L.right, R.left);
  }
}
