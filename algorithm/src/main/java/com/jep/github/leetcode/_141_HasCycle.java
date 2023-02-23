package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-02-21 2:13 AM
 */
public class _141_HasCycle {

  public static boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    //同时出发，fast走的快，只需要判断fast是不是已经走完了

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;

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


