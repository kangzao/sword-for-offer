package com.jep.github.leetcode;

import java.util.List;

/**
 * author jiangenping 2020/8/26 下午10:39 update 2022年06月08日16:19:39
 */

public class _124_MaxPathSum {

  private int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
  }

  //当前节点要么和左右子数的最大收益组成最大路径和，要么左右选一个最大的然后向上找父节点(防止走回头路)
  //计算当前节点为父节点提供的最大收益
  public int maxGain(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = maxGain(root.left);
    int right = maxGain(root.right);
    //经过当前节点的最大路径和
    maxSum = Math.max(left + right + root.val, maxSum);
    //计算当前对外的最大贡献值(要么选左子树，要么选右子树)
    int sum = Math.max(left + root.val, right + root.val);
    return Math.max(sum, 0);
  }
}
