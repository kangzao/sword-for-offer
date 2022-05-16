package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-05-16 5:03 下午
 */
public class _337_Rob {

  public int rob(TreeNode root) {
    /**
     * 分两种情况：
     * 1、偷root，则相邻的左右子树不能偷
     * 2、不偷root，则返回的是左子树的最大值和右子树的最大值
     */
    int[] res = dfs(root);
    return Math.max(res[0], res[1]);
  }

  public int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0};
    }
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);

    int[] dp = new int[2];
    //不偷root，则返回左子树的最大值和右子树的最大值，不管偷或不偷
    dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    //偷root，则相邻的左右子树不能偷
    dp[1] = root.val + left[0] + right[0];
    return dp;


  }

}
