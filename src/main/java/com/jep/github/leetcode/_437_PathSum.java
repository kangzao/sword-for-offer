package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-05-27 5:13 下午
 */
public class _437_PathSum {

  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    int sum = dfs(root, targetSum);//从根节点出发寻找路径和
    sum += pathSum(root.left, targetSum);//从左子树出发寻找路径和
    sum += pathSum(root.right, targetSum);//从右子树出发寻找路径和
    return sum;
  }

  //从root出发，向下寻找和为targetSum的链路数量
  public int dfs(TreeNode root, int targetSum) {
    int n = 0;
    if (root == null) {
      return 0;
    }
    if (root.val == targetSum) {
      n++;
    }
    n += dfs(root.left, targetSum - root.val);
    n += dfs(root.right, targetSum - root.val);
    return n;
  }

}
