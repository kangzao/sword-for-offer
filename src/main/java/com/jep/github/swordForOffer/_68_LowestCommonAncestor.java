package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;

/*
 * @author: enping.jep
 * @create: 2021-04-13 5:08 下午
 */
public class _68_LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || p == root || q == root || (p == null && q == null)) {
      return root;
    }
    if (p == q) {
      return p;
    }
    //在左子树中寻找p或者q
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    //在右子树中寻找p或者q
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    //左子树为空，说明全都在右子树
    if (left == null) {
      return right;
    }
    //右子树为空，说明pq都在左子树，返回找到的第一个节点即可
    if (right == null) {
      return left;
    }
    //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    return root;
  }

}
