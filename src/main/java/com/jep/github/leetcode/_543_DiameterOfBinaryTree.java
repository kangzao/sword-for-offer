package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-07 5:26 下午
 */
public class _543_DiameterOfBinaryTree {


  int max = 1;

  public int diameterOfBinaryTree(TreeNode root) {
    maxDepth(root);
    return max - 1;
  }

  //深度为根节点到最远叶子节点的最长路径上的节点数
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    //左子树的最大节点数
    int left = maxDepth(root.left);
    //右子树的最大节点数
    int right = maxDepth(root.right);
    //最大节点数 = 左子树+右子树+当前节点
    max = Math.max(max, left + right + 1);
    //root的最大节点数
    return Math.max(left, right) + 1;
  }

}
