package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-02-20 11:37 PM
 *
 * Given a linked list, swap every two adjacent nodes and return its head.

   You may not modify the values in the list's nodes, only nodes itself may be changed.

  Example:

    Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class _24_SwapPairs {


  public static ListNode recursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next;
    head.next = recursion(next.next);
    next.next = head;
    return next;
  }

  public static ListNode loop(ListNode head) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode prevNode = dummy;

    while (head != null && head.next != null) {
      ListNode firstNode = head;//1的位置
      ListNode secondNode = head.next;//2的位置

      prevNode.next = secondNode;//前驱节点指向2
      firstNode.next = secondNode.next;//1指向3
      secondNode.next = firstNode;//2指向1

      prevNode = firstNode;//前驱节点指向1
      head = prevNode.next;//重置头结点

      dummy.next.printNode();
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
//    node1.printNode();
    ListNode newNode = loop(node1);
//    newNode.printNode();
  }

}
