package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-11-24 11:08 AM
 */
public class _92_ReverseBetween {

  public static ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode joinNode = dummy;
    int count = 1;
    //从虚拟节点开始移动，移动m个位置
    while (count != m) {
      joinNode = joinNode.next;
      count++;
    }

    joinNode.next = reverse(joinNode.next, n - m + 1);
    return dummy.next;
  }

  //反转链表前N个元素
  private static ListNode reverse(ListNode head, int n) {
    ListNode reverseLast = head;//反转后的头结点
    ListNode dummy = null;//虚拟节点
    while (head != null && n != 0) {
      ListNode next = head.next;
      head.next = dummy;
      dummy = head;
      head = next;
      n--;
    }
    //链表分成两部分，将反转的部分和未反转的部分连接起来
    reverseLast.next = head;
    return dummy;
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
    reverseBetween(node1, 2, 4).printNode();
  }

}
