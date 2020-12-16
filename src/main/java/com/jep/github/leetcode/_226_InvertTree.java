package com.jep.github.leetcode;


/*
 * @author: enping.jep
 * @create: 2020-12-08 7:42 PM
 */
public class _226_InvertTree {

  public static TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    invertTree(root.left);
    invertTree(root.right);

    return root;
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(invertTree(root));
  }

}
