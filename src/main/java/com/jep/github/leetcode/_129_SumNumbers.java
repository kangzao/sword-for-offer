package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-05-27 9:21 上午
 */
public class _129_SumNumbers {


  public int sumNumbers(TreeNode root) {
    return helper(root, 0);
  }

  public int helper(TreeNode root, int preSum) {
    if (root == null) {
      return 0;
    }
    //当前节点的计算公式
    int temp = preSum * 10 + root.val;
    //递归退出条件
    if (root.left == null && root.right == null) {
      return temp;
    }
    //分别计算左右子树
    return helper(root.left, temp) + helper(root.right, temp);
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

    _129_SumNumbers sumNumbersInstance = new _129_SumNumbers();
    sumNumbersInstance.sumNumbers(root);
  }


}
