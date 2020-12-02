package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-12-02 11:03 AM
 *
 * 输入：root = [1,null,2,3]
   输出：[1,2,3]
 */
public class _144_PreorderTraversal {

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    preOrder(root, result);
    return result;
  }


  public static void preOrder(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    //根左右
    result.add(root.val);
    preOrder(root.left, result);
    preOrder(root.right, result);
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    System.out.println(preorderTraversal(root));
  }

}
