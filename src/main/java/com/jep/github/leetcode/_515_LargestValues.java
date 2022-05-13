package com.jep.github.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2022-05-13 12:40 下午
 */
public class _515_LargestValues {

  List<Integer> res = new ArrayList<>();

  public List<Integer> largestValues(TreeNode root) {
    if (root == null) {
      return res;
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offer(root);
    while (!deque.isEmpty()) {
      int minValue = Integer.MIN_VALUE;
      //层序遍历
      for (int i = deque.size() - 1; i >= 0; i--) {
        TreeNode node = deque.poll();

        minValue = Math.max(minValue, node.val);
        if (node.left != null) {
          deque.offer(node.left);
        }
        if (node.right != null) {
          deque.offer(node.right);
        }

      }
      res.add(minValue);

    }
    return res;
  }

}
