package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-13 7:43 下午
 */
public class _111_MinDepth {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = minDepth(root.left);
    int rightDepth = minDepth(root.right);

    return root.left == null || root.right == null ? leftDepth + rightDepth + 1
        : Math.min(leftDepth, rightDepth) + 1;

  }

}
