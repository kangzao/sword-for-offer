package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-02-21 2:13 AM
 */
public class _141_HasCycle {

  public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;

    while (slow != fast) {
      if (slow == null || fast == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }

  public static void main(String args[]) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    node1.next = node2;
    node2.next = node3;
    node3.next = node1;
    System.out.println(hasCycle(node1));
  }
}


