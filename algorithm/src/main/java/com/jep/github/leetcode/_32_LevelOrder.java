package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2022-05-05 2:35 下午
 */
public class _32_LevelOrder {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      //size会发生变化
      int len = queue.size();
      for (int i = 0; i < len; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      res.add(list);

    }
    return res;
  }
}
