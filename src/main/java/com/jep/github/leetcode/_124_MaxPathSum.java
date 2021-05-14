package com.jep.github.leetcode;

import java.util.List;

/**
 * author jiangenping 2020/8/26 下午10:39
 */

public class _124_MaxPathSum {

  int maxValue = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    getOneSideMaxValue(root);
    return maxValue;
  }

  //左子树或者右子树的最大值，因为从上游下来，要么走左子树,要么走右子树，然后更新到全局最大和
  /**
    a
   / \
  b  c   a是根节点，与上层父节点相连(如果有)，b、c是子节点，与其各自子节点中路径最大的节点相连
   所有可能的情况： b+a+c  b+a c+a
   **/
  public int getOneSideMaxValue(TreeNode root){

    if(root == null){
      return 0;
    }
    // 左子树提供的最大路径和
    int leftMaxValue = Math.max(0,getOneSideMaxValue(root.left));
    // 右子树提供的最大路径和
    int rightMaxValue = Math.max(0,getOneSideMaxValue(root.right));
    // 当前子树内部的最大路径和并挑战最大纪录
    maxValue = Math.max(maxValue,leftMaxValue + root.val + rightMaxValue);
    // 当前子树对外提供的最大路径和
    int outputMaxSum = root.val + Math.max(leftMaxValue,rightMaxValue);
    return Math.max(outputMaxSum, 0);
  }
}
