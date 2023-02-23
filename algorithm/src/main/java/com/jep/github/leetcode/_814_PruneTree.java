package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-05-18 10:38 上午
 */
public class _814_PruneTree {

  //删除全是0的元素
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    //自底向上，后续遍历
    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);
    if (root.val == 0 && root.left == null && root.right == null) {
      return null;
    }
    return root;
  }

}
