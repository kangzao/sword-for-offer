package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-12 4:18 下午
 * 2022年06月16日21:19:52
 */
public class _530_GetMinimumDifference {

  TreeNode pre;
  int gap = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    //按照中序遍历，中序遍历是升序，最小值在相邻元素间产生
    if (root == null) {
      return -1;
    }
    inOrder(root);
    return gap;
  }
  //中序遍历
  public void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    //左子树
    inOrder(root.left);
    //当前节点
    if (pre != null) {
      gap = Math.min(gap, root.val - pre.val);
    }
    pre = root;
    inOrder(root.right);
  }
}
