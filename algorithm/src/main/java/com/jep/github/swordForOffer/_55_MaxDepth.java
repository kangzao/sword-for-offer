package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;

/*
 * @author: enping.jep
 * @create: 2021-04-13 6:17 下午
 */
public class _55_MaxDepth {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

}
