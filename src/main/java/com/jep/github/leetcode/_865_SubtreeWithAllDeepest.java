package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-05-26 3:33 下午
 *
 */
public class _865_SubtreeWithAllDeepest {

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    //寻找左右子树的最大深度
    int leftDepth = getMaxDepth(root.left);
    int rightDepth = getMaxDepth(root.right);
    //如果深度相同，则root就是包含所有最大深度节点的最小子树
    if (leftDepth == rightDepth) {
      return root;
    }
    if (leftDepth > rightDepth) {
      return subtreeWithAllDeepest(root.left);
    }
    return subtreeWithAllDeepest(root.right);
  }

  public int getMaxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
  }

}
