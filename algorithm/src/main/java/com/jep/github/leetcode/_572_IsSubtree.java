package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-12 3:21 下午
 */
public class _572_IsSubtree {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    //t为null一定都是true
    if (t == null) {
      return true;
    }
    //这里 t 一定不为 null,只要 s 为 null肯定是 false
    if (s == null) {
      return false;
    }
    //t是s的左子树的子树 || t是s的右子树的子树 || s和t是同一棵树
    return isSametree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public boolean isSametree(TreeNode s, TreeNode t) {
    if (s == null || t == null) {
      return s == t;
    }
    if (s.val != t.val) {
      return false;
    }
    return isSametree(s.left, t.left) && isSametree(s.right, t.right);
  }

}
