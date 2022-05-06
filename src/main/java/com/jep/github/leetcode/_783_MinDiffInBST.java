package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-05-06 9:50 上午
 */
public class _783_MinDiffInBST {

  int res = Integer.MAX_VALUE;
  TreeNode pre;

  public int minDiffInBST(TreeNode root) {
    dfs(root);
    return res;

  }

  //root表示当前节点，pre表示前一个节点
  public void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    //左根右恰好是递增的数组
    dfs(root.left);
    if (pre != null) {
      res = Math.min(res, root.val - pre.val);
    }
    pre = root;
    dfs(root.right);

  }

  //[27,null,34,null,58,50,null,44]
  public static void main(String args[]) {
    TreeNode root = new TreeNode(27, null,
        new TreeNode(34, null, new TreeNode(58, new TreeNode(50, new TreeNode(44), null), null)));
    _783_MinDiffInBST obj = new _783_MinDiffInBST();
    int res = obj.minDiffInBST(root);
    System.out.println(res);
  }
}
