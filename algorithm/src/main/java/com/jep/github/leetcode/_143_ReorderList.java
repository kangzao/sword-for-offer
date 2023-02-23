package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-05-06 10:15 上午
 */
public class _143_ReorderList {

  public void reorderList(ListNode head) {
    //找到链表的中间 1->2->3->4->5->6
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    //分成两段,反转另外一段 1->2->3  6->5->4
    ListNode newHead = reverserList(slow.next);

    slow.next = null;
    //第二段插入到第一段中
    while (newHead != null && head != null) {
      ListNode next = head.next;
      ListNode newNext = newHead.next;
      head.next = newHead;
      newHead.next = next;
      head = next;
      newHead = newNext;
    }
  }

  public ListNode reverserList(ListNode head) {
    ListNode pre = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
  }

}
