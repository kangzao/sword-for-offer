package com.jep.github.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2021-03-31 5:17 下午
 */
public class _103_ZigzagLevelOrder {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> list = new LinkedList<>();
    if (root == null) {
      return list;
    }
    //存放每层的节点
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isOrderLeft = true;

    while (!queue.isEmpty()) {
      //存放每层的元素，需要按照锯齿顺序(从左到右或者从右到左),双端队列，可以在队列的两头进行操作
      Deque<Integer> levelList = new LinkedList<Integer>();
      int size = queue.size();
      //处理每一层
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (isOrderLeft) {
          levelList.offerLast(node.val);
        } else {
          levelList.offerFirst(node.val);
        }

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      list.add(new LinkedList<>(levelList));
      isOrderLeft = !isOrderLeft;
    }
    return list;
  }

}
