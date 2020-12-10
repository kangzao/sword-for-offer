package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-12-08 7:59 PM
 */
public class _116_Connect {


  public PerfectNode connect(PerfectNode root) {
    if (root == null || root.left == null) {
      return root;
    }

    connectTwoNode(root.left, root.right);
    return root;


  }

  //二叉树的问题难点在于，如何把题目的要求细化成每个节点需要做的事情
  public static void connectTwoNode(PerfectNode node1, PerfectNode node2) {
    if (node1 == null || node2 == null) {
      return;
    }
    node1.next = node2;

    connectTwoNode(node1.left, node1.right);
    connectTwoNode(node2.left, node2.right);
    connectTwoNode(node1.right, node2.left);

  }

  public static void main(String args[]) {

  }

}
