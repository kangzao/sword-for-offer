package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2022-03-25 3:07 下午
 */
public class _52_GetIntersectionNode {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode nodeA = headA, nodeB = headB;
    //共同走过两个链表后，nodeA和nodeB都会到达末尾，此时nodeA和nodeB的指针都会相等
    while (nodeA != nodeB) {
      nodeA = nodeA == null ? headB : nodeA.next;
      nodeB = nodeB == null ? headA : nodeB.next;
    }
    return nodeA;
  }

}
