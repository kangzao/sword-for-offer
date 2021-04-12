package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-12 10:03 上午
 */
public class _27_MirrorTree {

  public TreeNode mirrorTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode tmp = root.left;
    root.left = mirrorTree(root.right);
    root.right = mirrorTree(tmp);
    return root;
  }
}
