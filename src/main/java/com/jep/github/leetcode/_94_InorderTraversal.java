package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-12-01 7:36 PM
 * 给定一个二叉树的根节点 root ，返回它的中序遍历。
 */
public class _94_InorderTraversal {

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    //根左右
    result.add(root.val);
    inorderTraversal(root.left);
    inorderTraversal(root.right);


  }

  public static void main(String args[]) {

  }


}
