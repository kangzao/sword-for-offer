package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2021-04-25 5:11 下午
 */
public class _199_RightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new LinkedList();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        if (i == size - 1) {
          list.add(node.val);
        }

      }
    }
    return list;
  }

}
