package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-08 3:51 下午
 */
public class _110_IsBalanced {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(
        root.right);

  }

  /**
   * 计算root节点的高度
   **/
  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    return Math.max(height(left), height(right)) + 1;
  }

}
