package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-13 3:03 下午
 */
public class _257_BinaryTreePaths {

//  public List<String> binaryTreePaths(TreeNode root) {
//    List<String> list = new ArrayList();
//    if (root == null) {
//      return list;
//    }
//    StringBuilder sb = new StringBuilder();
//    dfs(root, sb, list);
//    return list;
//  }
//
//  public void dfs(TreeNode root, StringBuilder sb, List<String> list) {
//
//    if (root.left == null && root.right == null) {
//      sb.append(root.val);
//      list.add(sb.toString());
//      return;
//    }
//    sb.append(root.val);
//    if (root.left != null) {
//      dfs(root.left, new StringBuilder(sb).append("->"), list);
//    }
//    if (root.right != null) {
//      dfs(root.right, new StringBuilder(sb).append("->"), list);
//    }
//  }

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(root, sb, list);
    return list;
  }

  public void dfs(TreeNode root, StringBuilder sb, List<String> list) {
    System.out.println(root.val);
    //如果是叶子节点
    if (root.left == null && root.right == null) {
      sb.append(root.val + "");
      list.add(sb.toString());//走到叶子节点后，加入到集合中
      return;
    }
    sb.append(root.val);
    System.out.println("递归前sb:" + sb);
    if (root.left != null) {
      dfs(root.left, new StringBuilder(sb).append("->"), list);
    }
    if (root.right != null) {
      dfs(root.right, new StringBuilder(sb).append("->"), list);
    }
    System.out.println("递归后sb:" + sb);
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);

    _257_BinaryTreePaths btp = new _257_BinaryTreePaths();
    btp.binaryTreePaths(root);
  }
}
