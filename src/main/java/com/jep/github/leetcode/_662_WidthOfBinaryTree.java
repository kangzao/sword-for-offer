package com.jep.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @author: enping.jep
 * @create: 2021-07-12 3:34 下午
 */
public class _662_WidthOfBinaryTree {

  public int widthOfBinaryTree(TreeNode root) {
    int maxLen = 1;
    Deque<TreeNode> nodeDeque = new ArrayDeque<>();
    Deque<Integer> indexDeque = new ArrayDeque<>();
    nodeDeque.offer(root);
    indexDeque.offer(1);
    while (!nodeDeque.isEmpty()) {
      for (int i = nodeDeque.size() - 1; i >= 0; i--) {
        TreeNode node = nodeDeque.poll();
        Integer curIndex = indexDeque.poll();
        if (node.left != null) {
          nodeDeque.offer(node.left);
          indexDeque.offer(2 * curIndex);
        }
        if (node.right != null) {
          nodeDeque.offer(node.right);
          indexDeque.offer(2 * curIndex + 1);
        }
      }
      if (indexDeque.size() >= 2) {
        maxLen = Math.max(indexDeque.getLast() - indexDeque.getFirst() + 1, maxLen);
      }
    }
    return maxLen;
  }

  public static void main(String args[]) {
    TreeNode treeNode3 = new TreeNode(15);
    TreeNode treeNode4 = new TreeNode(7);
    TreeNode treeNode1 = new TreeNode(9);
    TreeNode treeNode2 = new TreeNode(20);
    treeNode1.left = treeNode3;
    treeNode2.right = treeNode4;
    TreeNode root = new TreeNode(3, treeNode1, treeNode2);

    _662_WidthOfBinaryTree width = new _662_WidthOfBinaryTree();
    width.widthOfBinaryTree(root);
  }

}
