package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2020-11-24 11:08 AM
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
   输出：[1,4,3,2,5]
 */
public class _92_ReverseBetween {

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    //定义双指针，一个指向被移动链表的头部，一个指向头部的前一个节点
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;

    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }
    ListNode cur = pre.next;
    for (int i = 0; i < right - left; i++) {
      //依次将next节点移动到pre后面
      ListNode next = cur.next;
      //让当前节点指向next节点之后的节点
      cur.next = cur.next.next;
      //这里不能写成cur，头插法的意思是依次将next节点放到pre的后面，然后让next指向紧邻pre的节点pre.next
      next.next = pre.next;
      pre.next = next;
      head.printNode();

    }
    return dummy.next;
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
//    node1.printNode();
    reverseBetween(node1, 2, 4).printNode();
  }

}
