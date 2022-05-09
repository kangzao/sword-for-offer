package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-05-27 9:21 上午
 */
public class _129_SumNumbers {

  int res = 0;

  public int sumNumbers(TreeNode root) {
    dfs(root, new ArrayList<>());
    return res;
  }

  public void dfs(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    if (root.left == null && root.right == null) {
      res += getSum(list);
    }
    dfs(root.left, list);
    dfs(root.right, list);
    list.remove(list.size() - 1);
  }

  //路径上的和
  public int getSum(List<Integer> list) {
    int sum = 0;
    for (Integer item : list) {
      sum = sum * 10 + item;
    }
    return sum;
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
