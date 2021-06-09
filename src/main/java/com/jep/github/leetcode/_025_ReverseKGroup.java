package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/**
 * author jiangenping 2020/2/22 下午4:04
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified
 * list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number
 * of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>ø
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed. You may not alter the values in the list's nodes, only
 * nodes itself may be changed.
 */

public class _025_ReverseKGroup {

  /**
   * 反转链表，返回新的头和尾
   */
  private static ListNode[] reverse(ListNode head, ListNode tail) {
    //pre是head之前的节点
    ListNode pre = null;
    ListNode dummy = head;
    //pre移动到tail的位置，则循环结束
    while (pre != tail) {
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    //此时pre是头结点，尾节点是dummy
    return new ListNode[]{tail, dummy};


  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    //hair指针不动，用来记录链表的头结点位置
    ListNode hair = new ListNode(0);
    hair.next = head;
    //tail指针移动k个位置
    ListNode tail = hair;
    //pre指针记录被移动那一组元素的前驱节点
    ListNode pre = hair;
    while (head != null) {
      //tail指针指向要反转链表的最后一个节点
      for (int i = 0; i < k; i++) {
        tail = tail.next;
        //长度不够直接返回
        if (tail == null) {
          return hair.next;
        }

      }
      //被翻转的那组节点之后的节点
      ListNode next = tail.next;
      //反转从cur到tail之间的节点
      ListNode[] listNodes = reverse(head, tail);
      head = listNodes[0];
      tail = listNodes[1];

      //一组链表反转完成后，需要重新拉链
      pre.next = head;
      tail.next = next;

      //移动pre和head，pre始终指向一组节点的前驱节点，head指向被移动那组节点的头结点
      pre = tail;
      head = tail.next;
    }
    return hair.next;
  }

  //左闭右开区间,返回翻转后的头节点
  public static ListNode reverse_recursion(ListNode head, ListNode tail) {
    ListNode pre = new ListNode();
    ListNode next = null;
    while (head != tail) {
      next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;

  }


  public static ListNode reverseKGroup_recursion(ListNode head, int k) {
    //1、走到第k个元素
    ListNode tail = head;
    //需要注意边界，因为k可能等于1，需要多移动一位，否则需要单独处理边界问题
    for (int i = 0; i < k; i++) {
      if (tail == null) {
        return head;
      }
      tail = tail.next;
    }

    //2、翻转这k个元素
    ListNode newHead = reverse_recursion(head, tail);
    head.printNode();

    //3、翻转第二组k个元素后和第一组相连
    head.next = reverseKGroup_recursion(tail, k);

    head.printNode();
    return newHead;
  }

  public static void reset(ListNode listNode) {
    listNode.val = Integer.MAX_VALUE;
    listNode.next = new ListNode(Integer.MIN_VALUE);
  }

  public static void main(String[] args) {
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
//    reverse(node1, node6);
//    reverseKGroup_recursion(node1, 2).printNode();
//    node1.printNode();

//    reverse_recursion(node1, node4).printNode();
//    node1.printNode();
//    reset(node1);
//    node1.printNode();
  }
}
