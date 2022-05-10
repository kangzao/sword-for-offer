package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-05 3:43 下午
 */
public class _98_IsValidBST {

  TreeNode pre;

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (!isValidBST(root.left)) {
      return false;
    }

    //中序遍历必须递增
    if (pre != null && root.val <= pre.val) {
      return false;
    }
    pre = root;
    return isValidBST(root.right);
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(6);
    _98_IsValidBST isValidBSTInstance = new _98_IsValidBST();
    isValidBSTInstance.isValidBST(root);

  }

}
