package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2021-04-13 10:32 上午
 */
public class _107_LevelOrderBottom {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> levelList = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        levelList.add(node.val);
        TreeNode left = node.left, right = node.right;
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        }
      }
      res.add(0, levelList);
    }
    return res;
  }

}
