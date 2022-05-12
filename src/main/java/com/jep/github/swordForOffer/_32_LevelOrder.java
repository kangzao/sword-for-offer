package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2022-05-12 8:17 下午
 */
public class _32_LevelOrder {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    int n = 1;
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offer(root);
    while (!deque.isEmpty()) {
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = deque.size() - 1; i >= 0; i--) {
        TreeNode node = deque.poll();
        if (n % 2 == 1) {
          list.addLast(node.val);
        } else {
          list.addFirst(node.val);
        }

        if (node.left != null) {
          deque.offer(node.left);
        }
        if (node.right != null) {
          deque.offer(node.right);
        }
      }
      n++;
      res.add(list);
    }
    return res;
  }
}
