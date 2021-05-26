package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-05-26 4:43 下午
 */
public class _113_PathSum {

  List<List<Integer>> res = new ArrayList<>();
  Deque<Integer> path = new LinkedList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return res;
    }
    dfs(root, targetSum);
    return res;
  }

  public void dfs(TreeNode root, int targetSum) {
    if (root == null) {
      return;
    }
    targetSum -= root.val;
    path.offerLast(root.val);
    //如果递归到叶子节点
    if (root.left == null && root.right == null && targetSum == 0) {
      res.add(new ArrayList<>(path));
    }
    dfs(root.left, targetSum);
    dfs(root.right, targetSum);

    //回溯
    //sum是int类型，传值的话，不论内层函数怎么改，都不会影响外层函数的sum的值
    //但是path就不一样了，是个指针，如果内层函数改了path，外层函数看path也会被修改
    path.pollLast();

  }

  /**
            5
           / \
          3   6
         / \   \
        1   4   7
   */

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

    _113_PathSum pathSumInstance = new _113_PathSum();
    pathSumInstance.pathSum(root,9);

  }

}
