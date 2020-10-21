package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-06-23 11:20 AM
 */
public class _160_GetIntersectionNode {

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode dummyA = headA;
    ListNode dummyB = headB;
    while (dummyA != dummyB) {
      if (dummyA == null) {
        dummyA = headB;
      }
      dummyA = dummyA.next;
      if (dummyB == null) {
        dummyB = headA;
      }
      dummyB = dummyB.next;

    }
    return dummyA;
  }

  public static void main(String args[]) {

  }

}
