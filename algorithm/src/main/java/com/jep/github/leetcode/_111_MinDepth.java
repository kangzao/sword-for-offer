package com.jep.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @author: enping.jep
 * @create: 2021-04-13 7:43 下午
 */
public class _111_MinDepth {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Deque<TreeNode> deque = new ArrayDeque();
    deque.offer(root);
    int depth = 1;
    while (!deque.isEmpty()) {
      int len = deque.size();
      for (int i = 0; i < len; i++) {
        TreeNode node = deque.poll();
        if (node.left == null && node.right == null) {
          return depth;
        }
        if (node.left != null) {
          deque.offer(node.left);
        }
        if (node.right != null) {
          deque.offer(node.right);
        }
      }
      depth++;
    }
    return depth;
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(5);
    root.right.right.right.right = new TreeNode(6);
    _111_MinDepth minDepth = new _111_MinDepth();
    System.out.println(minDepth.minDepth(root));
  }

}
