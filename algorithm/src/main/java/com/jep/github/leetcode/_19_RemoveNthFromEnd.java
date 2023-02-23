package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-08-17 2:39 下午
 */
public class _19_RemoveNthFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode slow = dummy, fast = dummy;
    for (int i = 0; i < n + 1; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }

  public static void main(String args[]) {
    ListNode head = new ListNode(1);
    _19_RemoveNthFromEnd solution = new _19_RemoveNthFromEnd();
    solution.removeNthFromEnd(head, 1);
  }

}
