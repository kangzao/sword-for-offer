package com.jep.github.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-03-31 5:17 下午
 */
public class _103_ZigzagLevelOrder {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    //奇数层从左往右，偶数层从右往左
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.offer(root);
    boolean leftToRight = true;//打印顺序
    while (!deque.isEmpty()) {
      LinkedList<Integer> list = new LinkedList<>();
      int len = deque.size();

      for (int i = 0; i < len; i++) {
        TreeNode node = deque.poll();//队列从头部移除，尾部加入

        //从左往右打印，则将节点放到队尾
        if (leftToRight) {
          list.add(node.val);
        } else {
          //从右往左打印，则将节点放到头部
          list.addFirst(node.val);
        }
        if (node.left != null) {
          deque.add(node.left);
        }
        if (node.right != null) {
          deque.add(node.right);
        }
      }
      leftToRight = !leftToRight;
      res.add(list);
    }
    return res;
  }

}
