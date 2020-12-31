package com.jep.github.leetcode;

public class TreeNode {

  public Integer val;
  public TreeNode left;
  public TreeNode right;

  TreeNode() {
  }

  TreeNode(Integer val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return val + "";
  }
}