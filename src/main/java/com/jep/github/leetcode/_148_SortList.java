package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-08-17 4:07 下午
 */
public class _148_SortList {

  public ListNode sortList(ListNode head) {
    return sort(head, null);
  }

  public ListNode sort(ListNode start, ListNode end) {
    //只有一个节点
    if (start == end) {
      return start;
    }
    //找到链表的中点
    ListNode slow = start, fast = start;
    while (fast != end && fast.next != end) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode right = sort(slow.next, end);
    slow.next = null;
    ListNode left = sort(start, slow);
    return merge(left, right);
  }

  public ListNode merge(ListNode left, ListNode right) {
    if (left == null || right == null) {
      return left == null ? right : left;
    }
    if (left.val < right.val) {
      left.next = merge(left.next, right);
      return left;
    } else {
      right.next = merge(left, right.next);
      return right;
    }
  }
}
