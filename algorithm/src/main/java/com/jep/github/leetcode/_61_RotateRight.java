package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-08-20 3:16 下午
 */
public class _61_RotateRight {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    if (k == 0) {
      return head;
    }
    ListNode cur = head;
    //count是节点数
    int count = 0;
    while (cur != null) {
      cur = cur.next;
      count++;
    }
    //将链表分为两部分
    int n = k % count;
    if (n == 0) {
      return head;
    }
    ListNode node = head;
    for (int i = 0; i < count - n - 1; i++) {
      node = node.next;
    }
    ListNode rightHead = node.next;
    ListNode res = rightHead;
    node.next = null;
    while (rightHead.next != null) {
      rightHead = rightHead.next;
    }
    rightHead.next = head;
    return res;
  }


  public ListNode rotateRight_optimize(ListNode head, int k) {
    if (k == 0 || head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    //节点数量
    int count = 1;
    while (cur.next != null) {
      cur = cur.next;
      count++;
    }
    int n = k % count;
    if (n == 0) {
      return head;
    }
    //形成环
    cur.next = head;
    cur = head;

    for (int i = 0; i < count - n - 1; i++) {
      cur = cur.next;
    }
    head = cur.next;

    cur.next = null;
    return head;
  }


}
