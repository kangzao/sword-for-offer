package com.jep.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @author: enping.jep
 * @create: 2022-05-13 5:59 下午
 */
public class _1302_DeepestLeavesSum {

  public int deepestLeavesSum(TreeNode root) {
    Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
    deque.offer(root);
    int sum = 0;
    //找到最后一层，将最后一层的节点值求和即可
    while (!deque.isEmpty()) {
      sum = 0;
      for (int i = deque.size() - 1; i >= 0; i--) {
        TreeNode node = deque.poll();
        if (node.left != null) {
          deque.offer(node.left);
        }
        if (node.right != null) {
          deque.offer(node.right);
        }

        sum += node.val;

      }
    }
    return sum;
  }

}
