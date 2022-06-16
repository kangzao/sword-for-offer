package com.jep.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @author: enping.jep
 * @create: 2022-06-16 9:06 下午
 */

class NextNode {

  public int val;
  public NextNode left;
  public NextNode right;
  public NextNode next;

  public NextNode() {
  }

  public NextNode(int _val) {
    val = _val;
  }

  public NextNode(int _val, NextNode _left, NextNode _right, NextNode _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}

public class _117_Connect {

  public NextNode connect(NextNode root) {
    if (root == null) {
      return null;
    }
    Deque<NextNode> deque = new ArrayDeque<>();
    deque.offer(root);
    while (!deque.isEmpty()) {
      //层序遍历
      int len = deque.size();
      NextNode pre = null;
      for (int i = 0; i < len; i++) {
        NextNode node = deque.poll();
        if (i == 0) {
          pre = node;
        } else {
          pre.next = node;
          pre = node;
        }
        if (i == len - 1) {
          pre.next = null;
        }
        if (node.left != null) {
          deque.offer(node.left);
        }
        if (node.right != null) {
          deque.offer(node.right);
        }
      }
    }
    return root;
  }

}
