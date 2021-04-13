package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2021-04-13 7:30 下午
 */
public class _637_AverageOfLevels {

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> list = new ArrayList();
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        TreeNode left = node.left, right = node.right;
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        }
      }
      list.add(sum / size);
    }
    return list;

  }
}
