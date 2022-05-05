package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-05-05 4:59 下午
 */
public class _897_IncreasingBST {

  TreeNode head = new TreeNode(-1);
  TreeNode pre = head;

  public TreeNode increasingBST(TreeNode root) {
    dfs(root);
    return head.right;

  }

  public void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    //左根右
    dfs(root.left);
    pre.right = root;
    root.left = null;
    pre = root;
    dfs(root.right);
  }
}
