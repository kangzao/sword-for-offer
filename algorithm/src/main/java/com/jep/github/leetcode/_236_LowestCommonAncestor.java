package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-25 11:00 上午
 */
public class _236_LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return dfs(root, p, q);

  }

  //在root中寻找p或q
  public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
    //只要当前根节点是p和q中的任意一个，就返回（因为不能比这个更深了，再深p和q中的一个就没了）
    if (root == null || p == root || q == root) {
      return root;
    }
    //根节点不是p和q中的任意一个，那么就继续分别往左子树和右子树找p和q
    TreeNode left = dfs(root.left, p, q);//在左子树中寻找
    TreeNode right = dfs(root.right, p, q);//在右子树中寻找
    //左右子树中都没有找到
    if (left == null && right == null) {
      return null;
    }
    //左子树中没有p和q
    if (left == null) {
      return right;
    }
    //右子树中没有p和q
    if (right == null) {
      return left;
    }
    //左右子树都找到p和q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
    return root;
  }

}
