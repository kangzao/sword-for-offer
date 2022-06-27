package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-06-27 1:56 下午
 * 二插搜索树转成有序双向链表
 *        4
 *     2     5
 *   1   3
 *
 *  12345，5的right为1，1的left为5
 */
public class _426_TreeToDoublyList {

  DoubleNode prev = null, head = null, tail = null;//head指向1 tail指向5

  public DoubleNode treeToDoublyList(DoubleNode root) {

    if (root == null) {
      return null;
    }
    inorder(root);//中序遍历
    head.left = tail;//设置头部的左节点
    tail.right = head;//设置尾部的右节点
    return head;
  }

  public void inorder(DoubleNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    if (prev == null) {
      prev = root;//访问首个节点，给prev赋初值
      head = root;//访问首个节点，给head赋初值
    } else {

      prev.right = root;
      root.left = prev;
      prev = root;
    }
    tail = root;//tail更新成最右侧节点
    inorder(root.right);
  }

}


class DoubleNode {

  public int val;
  public DoubleNode left;
  public DoubleNode right;

  public DoubleNode() {
  }

  public DoubleNode(int _val, DoubleNode _left, DoubleNode _right) {
    val = _val;
    left = _left;
    right = _right;
  }
};
