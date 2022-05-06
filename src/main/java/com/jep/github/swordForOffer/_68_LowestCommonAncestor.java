package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;

/*
 * @author: enping.jep
 * @create: 2021-04-13 5:08 下午
 */
public class _68_LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //最近公共祖先
    //分情况讨论 ：

    //p或者q在root的左右子树中，则返回root
    //p在q的左或者右侧子树中
    //q在p的左或者右侧子树中

    if (root == null) {
      return null;
    }
    //p或者q有一个是root，则直接返回root
    if (p == root || q == root) {
      return root;
    }
    //在左子树中查找p或者q
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    //两侧都找不到，返回null
    if (left == null && right == null) {
      return null;
    } else if (left != null && right != null) {
      return root;//都找到，说明在两侧,root才是公共祖先
    } else {//至少找到一个，另一个要么是空，要么是先找到那个节点的子节点
      return left == null ? right : left;
    }
  }

}
