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
 * <p>
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
  private static ListNode[] reverse(ListNode begin, ListNode end) {
    ListNode reverseTail = begin;
    ListNode reverseHead = null;
    while (reverseHead != end) {
      ListNode next = begin.next;
      begin.next = reverseHead;
      reverseHead = begin;
      begin = next;
    }
    return new ListNode[]{reverseHead, reverseTail};
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    //被翻转子链表前的节点
    ListNode pre = dummy;

    while (head != null) {
      //子链表的最后一个节点
      ListNode end = pre;
      //走k步后停下来，如果长度不够K，则返回头结点
      for (int i = 0; i < k; i++) {
        end = end.next;
        if (end == null) {
          return dummy.next;
        }
      }

      //子链表的下一个节点
      ListNode next = end.next;
      //翻转子链表
      ListNode[] listNodes = reverse(head, end);
      //翻转后的子链表头部
      head = listNodes[0];
      //翻转后的子链表尾部
      end = listNodes[1];

      //连接前半部分
      pre.next = head;
      //连接后半部分
      end.next = next;

      pre = end;
      head = end.next;


    }

    return dummy.next;
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
//    node1.printNode();
//    reverse(node1, node6);
    reverseKGroup(node1, 2).printNode();

  }
}
