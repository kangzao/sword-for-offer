package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-12-01 7:36 PM
 * 给定一个二叉树的根节点 root ，返回它的中序遍历。
 * 2021年05月13日15:11:50
 * 2022年06月08日16:27:04
 */
public class _94_InorderTraversal {

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    return result;
  }

  public static void inorder(TreeNode root, List result) {
    if (root == null) {
      return;
    }
    inorder(root.left, result);
    result.add(root.val);
    inorder(root.right, result);
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    System.out.println(inorderTraversal(root));

  }


}
