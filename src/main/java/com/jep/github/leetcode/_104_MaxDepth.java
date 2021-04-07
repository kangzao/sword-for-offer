package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-07 3:39 下午
 */
public class _104_MaxDepth {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    //左右子树最大深度，加上当前层
    return Math.max(maxDepth(left), maxDepth(right)) + 1;
  }

}
