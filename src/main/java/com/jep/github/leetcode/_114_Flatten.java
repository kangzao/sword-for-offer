package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-12-10 3:50 PM
 */
public class _114_Flatten {


  //最直观的方法，先前序遍历放到集合中再调整各节点关系
  public static void flatten(TreeNode root) {
    List<TreeNode> list = new ArrayList<>();
    preorderTraversal(root, list);

    for (int i = 1; i < list.size(); i++) {
      TreeNode tmp;
      tmp = list.get(i - 1);
      tmp.right = list.get(i);
      tmp.left = null;
    }

  }


  public static void flatten1(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.left);
    flatten(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = null;
    root.right = left;
    TreeNode p = root;
    while (p.right != null) {
      p = p.right;
    }
    p.right = right;

  }


  //前序遍历
  public static void preorderTraversal(TreeNode root, List<TreeNode> list) {
    if (root == null) {
      return;
    }
    list.add(root);
    preorderTraversal(root.left, list);
    preorderTraversal(root.right, list);

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
