package com.jep.github.leetcode;

import com.jep.github.leetcode.TreeNode;

/*
 * @author: enping.jep
 * @create: 2020-12-31 9:30 上午
 */
public class _538_ConvertBST {


  public TreeNode convertBST(TreeNode root) {
    dfs(root, 0);
    return root;
  }

  /**
   * @param sum 右侧子树中所有节点的和
   */
  public int dfs(TreeNode root, int sum) {
    if (root == null) {
      return sum;
    }
    root.val += dfs(root.right, sum);
    return dfs(root.left, root.val);
  }
}
