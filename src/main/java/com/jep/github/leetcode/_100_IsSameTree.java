package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-12 10:38 上午
 */
public class _100_IsSameTree {

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) {
      return p == q;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

}
