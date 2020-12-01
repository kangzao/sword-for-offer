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

    ListNode pre = null;
    ListNode p = head;
    while (pre != tail) {
      ListNode next = p.next;
      p.next = pre;
      pre = p;
      p = next;
    }

    return new ListNode[]{pre, head};
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode();
    dummy.next = head;
    //被翻转子链表的前驱节点
    ListNode prev = dummy;
    while (head != null) {
      //end为子链表的尾节点
      ListNode end = prev;
      //end走K步
      for (int i = 0; i < k; i++) {
        end = end.next;
        //节点数不足K个，直接返回
        if (end == null) {
          return dummy.next;
        }
      }
      //子链表的下一个节点
      ListNode next = end.next;
      //翻转K个节点,head为待翻转链表的头结点
      head = prev.next;
      ListNode[] listNodes = reverse(head, end);
      //交换start和end的位置，因为子链表被翻转了
      head = listNodes[0];
      end = listNodes[1];

      //连接前半部分
      prev.next = head;
      //连接后半部分
      end.next = next;

      //移动指针
      prev = end;
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
