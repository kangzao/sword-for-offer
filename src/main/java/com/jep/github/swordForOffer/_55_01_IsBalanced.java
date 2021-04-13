package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;
import com.jep.github.leetcode._297_Codec;

/*
 * @author: enping.jep
 * @create: 2021-04-13 6:59 下午
 */
public class _55_01_IsBalanced {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left)
        && isBalanced(root.right);
  }

  //计算root为根的树的最大深度
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftVal = maxDepth(root.left);
    System.out.println("leftVal ==" + leftVal);
    int rightVal = maxDepth(root.right);
    System.out.println("rightVal ==" + rightVal);
    return Math.max(leftVal, rightVal) + 1;
  }

  public static void main(String args[]) {

    TreeNode root = new TreeNode(5);
    TreeNode treeNode1 = new TreeNode(3);
    TreeNode treeNode2 = new TreeNode(6);
    TreeNode treeNode3 = new TreeNode(1);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(7);

    root.left = treeNode1;
    root.right = treeNode2;

    treeNode1.left = treeNode3;
    treeNode1.right = treeNode4;
    treeNode2.right = treeNode5;

    _55_01_IsBalanced isBalanced = new _55_01_IsBalanced();
    isBalanced.isBalanced(root);


  }

}
