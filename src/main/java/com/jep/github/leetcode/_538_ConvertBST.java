package com.jep.github.leetcode;

import com.jep.github.leetcode.TreeNode;

/*
 * @author: enping.jep
 * @create: 2020-12-31 9:30 上午
 */
public class _538_ConvertBST {

  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root == null) {
      return null;
    }
    convertBST(root.right);
    sum += root.val;
    root.val = sum;
    convertBST(root.left);
    return root;
  }
}
