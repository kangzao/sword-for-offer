package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-02-27 4:45 PM
 */
public class _021_MergeTwoLists {

  public static ListNode recursion(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

//    如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接,返回排序好的链表头
    if (l1.val < l2.val) {
      l1.next = recursion(l1.next, l2);
      return l1;
    } else {
      l2.next = recursion(l1, l2.next);
      return l2;
    }
  }

  public static ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();

    ListNode newHead = dummy;
    while (l1 != null || l2 != null) {
      if (l2 == null || (l1 != null && l1.val < l2.val)) {
        newHead.next = l1;
        newHead = l1;
        l1 = l1.next;
      } else {
        newHead.next = l2;
        newHead = l2;
        l2 = l2.next;
      }

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

    ListNode node7 = new ListNode(1);
    ListNode node8 = new ListNode(2);
    ListNode node9 = new ListNode(3);
    node7.next = node8;
    node8.next = node9;

//    recursion(node1, node7).printNode();
    merge(node1, node7).printNode();

  }

}
