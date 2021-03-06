package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-02-14 7:42 PM
 * 反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
 */
public class _206_ReverseLinkedList {

  public static ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  public static ListNode reverseList_recursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode last = reverseList_recursion(head.next);
    head.next.next = head;
    head.next = null;
    return last;
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
    ListNode newNode = reverseList_recursion(node1);
    newNode.printNode();


  }

}
