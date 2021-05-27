package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-11-24 11:08 AM
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
   输出：[1,4,3,2,5]
 */
public class _92_ReverseBetween {

  public static ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    //pre表示被翻转节点的前一个节点
    for (int i = 0; i < m - 1; i++) {
      pre = pre.next;
    }
    ListNode cur = pre.next;
    for (int i = 0; i < n - m; i++) {
      ListNode next = cur.next;
      cur.next = next.next;
      next.next = pre.next;
      pre.next = next;
      pre.printNode();
    }

    return dummy.next;


  }


  public static void main(String args[]) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node1.printNode();
    reverseBetween(node1, 2, 4).printNode();
  }

}
