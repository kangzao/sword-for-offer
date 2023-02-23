package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-06-30 3:48 PM
 *
 * 输入: 1->2->3->4->5->NULL
   输出: 1->3->5->2->4->NULL
 */
public class _328_OddEvenList {

  public static ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode even = head.next;
    ListNode odd = head;
    while (odd.next != null && odd.next.next != null) {
      ListNode evenNode = odd.next;
      odd.next = odd.next.next;
      evenNode.next = evenNode.next.next;
      odd = odd.next;
      evenNode = evenNode.next;

    }
    odd.next = even;
    return head;

  }


  public static void main(String args[]) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
//    ListNode node6 = new ListNode(6);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
//    node5.next = node6;

    node1.printNode();
    oddEvenList(node1).printNode();

  }

}
