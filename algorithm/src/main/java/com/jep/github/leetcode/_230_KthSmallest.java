package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-12-31 7:35 上午
 */
public class _230_KthSmallest {

  int cnt = 0;//遍历次数
  int res = 0;//结果

  public int kthSmallest(TreeNode root, int k) {
    dfs(root, k);
    return res;
  }

  public void dfs(TreeNode root, int k) {
    if (root == null) {
      return;
    }
    dfs(root.left, k);
    cnt++;
    if (cnt == k) {
      res = root.val;
      return;
    }
    dfs(root.right, k);
  }
}
