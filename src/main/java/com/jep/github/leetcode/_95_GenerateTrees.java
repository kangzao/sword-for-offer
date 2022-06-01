package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2022-05-26 5:22 下午
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class _95_GenerateTrees {

  public List<TreeNode> generateTrees(int n) {
    if (n < 1) {
      return new ArrayList<>();
    }
    return build(1, n);
  }

  //递归构造树
  public List<TreeNode> build(int start, int end) {
    List<TreeNode> list = new ArrayList<>();

    if (start > end) {
      //start大于end时，说明是空节点，空节点也要加入到列表中，以避免下方嵌套for循环进不去
      list.add(null);
      return list;
    }
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftTree = build(start, i - 1);
      List<TreeNode> rightTree = build(i + 1, end);
      //左子树不动，构建右子树
      for (TreeNode left : leftTree) {
        for (TreeNode right : rightTree) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          list.add(root);
        }
      }
    }
    return list;
  }

}
