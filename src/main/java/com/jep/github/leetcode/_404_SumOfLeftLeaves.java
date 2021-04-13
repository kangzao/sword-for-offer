package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-13 11:14 上午
 */
public class _404_SumOfLeftLeaves {

  public int sumOfLeftLeaves(TreeNode root) {
    int sum = 0;
    if (root == null) {
      return sum;
    }
    //左叶子节点必须满足两个条件：
    // 1、是某个节点的左节点 2、该节点必须是叶子节点
    TreeNode left = root.left;
    if (left != null && isLeaf(left)) {
      sum += left.val;
    }
    sum += sumOfLeftLeaves(left);
    sum += sumOfLeftLeaves(root.right);
    return sum;
  }

  public boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }

}
