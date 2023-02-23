package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-12 4:47 下午
 */
public class _617_MergeTrees {

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }
    TreeNode node = new TreeNode(root1.val + root2.val);
    node.left = mergeTrees(root1.left, root2.left);
    node.right = mergeTrees(root1.right, root2.right);
    return node;
  }

}
