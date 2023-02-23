package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2020-12-03 3:43 PM
 */
public class _429_LevelOrder {

  public static List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        level.add(node.val);
        queue.addAll(node.children);
      }
      result.add(level);
    }
    return result;
  }

}
