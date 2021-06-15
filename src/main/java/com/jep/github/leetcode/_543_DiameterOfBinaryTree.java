package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-07 5:26 下午
 */
public class _543_DiameterOfBinaryTree {


  int max = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return max;
  }

  // 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
  // 两个叶子节点之间的路径 = 根节点左右儿子的深度之和(深度指当前节点的层数，比如：叶子节点深度为1)
  public int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = depth(root.left);
    int right = depth(root.right);
    max = Math.max(max, left + right);
    //返回节点深度 左子树深度和右子树深度的最大值+1
    return Math.max(left, right) + 1;
  }

}
