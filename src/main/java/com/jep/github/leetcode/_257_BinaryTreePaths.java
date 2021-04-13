package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-13 3:03 下午
 */
public class _257_BinaryTreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> list = new ArrayList();
    if (root == null) {
      return list;
    }
    StringBuilder sb = new StringBuilder();
    dfs(root, sb, list);
    return list;
  }

  public void dfs(TreeNode root, StringBuilder sb, List<String> list) {

    if (root.left == null && root.right == null) {
      sb.append(root.val);
      list.add(sb.toString());
      return;
    }
    sb.append(root.val);
    if (root.left != null) {
      dfs(root.left, new StringBuilder(sb).append("->"), list);
    }
    if (root.right != null) {
      dfs(root.right, new StringBuilder(sb).append("->"), list);
    }
  }
}
