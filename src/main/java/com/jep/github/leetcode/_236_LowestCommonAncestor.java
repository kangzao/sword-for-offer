package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-25 11:00 上午
 */
public class _236_LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //找到P或者q
    if (root == null || root == p || root == q) {
      return root;
    }
    //在左子树中寻找
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    //在右子树中寻找
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    //p和q分别在左右子树
    if (left != null && right != null) {
      return root;
    }
    //p和q都在右子树，返回右子树的节点，left和right都为空的情况也包含在此判断内
    if (left == null) {
      return right;
    }
    //否则返回左子树
    return left;

  }

}
