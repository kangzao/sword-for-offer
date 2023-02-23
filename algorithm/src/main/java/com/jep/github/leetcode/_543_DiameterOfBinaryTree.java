package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-07 5:26 下午
 * 2022年06月13日14:53:21
 */
public class _543_DiameterOfBinaryTree {


  int res = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    //经过root要么沿着左子树向下，要么沿着右子树向下
    //即：左子树最大深度 + 右子树最大深度- 1
    dfs(root);
    return res - 1;

  }

  //求root为根的树的最大深度
  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = dfs(root.left);//左子树的最大深度，向左，求左子树的最大深度
    int right = dfs(root.right);//右子树的最大深度，向右，求右子树的最大深度
    res = Math.max(left + right + 1, res);//当前节点的最大深度，即：向左走的最大深度+向右走的最大深度+1
    return Math.max(left, right) + 1;
  }

}
