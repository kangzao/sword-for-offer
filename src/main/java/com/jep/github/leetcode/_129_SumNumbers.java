package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-05-27 9:21 上午
 */
public class _129_SumNumbers {

  int sum = 0;
  StringBuilder sb = new StringBuilder();

  public int sumNumbers(TreeNode root) {
    dfs(root);
    return sum;
  }

  public void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    sb.append(root.val);
    if (root.left == null && root.right == null) {
      sum += Integer.parseInt(sb.toString());
    }
    dfs(root.left);
    dfs(root.right);

    sb = sb.deleteCharAt(sb.length() - 1);

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
