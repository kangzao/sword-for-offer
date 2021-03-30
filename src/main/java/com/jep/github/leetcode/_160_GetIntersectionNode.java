package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-06-23 11:20 AM
 */
public class _160_GetIntersectionNode {

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    /**
     * pA走过的路径为A链+B链
     *
     * pB走过的路径为B链+A链
     *
     * pA和pB走过的长度都相同，都是A链和B链的长度之和，相当于将两条链从尾端对齐，如果相交，则会提前在相交点相遇，如果没有相交点，则会在最后相遇。
     *
     * pA:1->2->3->4->5->6->null->9->5->6->null
     * pB:9->5->6->null->1->2->3->4->5->6->null
     */
    if (headA == null || headB == null) {
      return null;
    }
    ListNode A = headA, B = headB;
    while (A != B) {
      A = A != null ? A.next : headB;
      B = B != null ? B.next : headA;
    }
    return A;
  }

  public static void main(String args[]) {

  }

}
