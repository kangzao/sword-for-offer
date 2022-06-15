package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-12-10 3:50 PM
 * 2022年06月14日20:51:59
 */
public class _114_Flatten {

  public static void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);
    //左右子树已被拉成一条链表
    TreeNode left = root.left;
    TreeNode right = root.right;

    root.right = left;
    root.left = null;

    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = right;

  }

  public static void main(String args[]) {

    TreeNode treeNode3 = new TreeNode(15);
    TreeNode treeNode4 = new TreeNode(7);
    TreeNode treeNode1 = new TreeNode(9);
    TreeNode treeNode2 = new TreeNode(20);
    treeNode1.left = treeNode3;
    treeNode2.right = treeNode4;
    TreeNode root = new TreeNode(3, treeNode1, treeNode2);
    flatten(root);
    System.out.println(root);


  }

}
