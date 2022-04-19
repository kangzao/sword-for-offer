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

  public ListNode sortList_1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    //找到中点
    System.out.println("head param ==" + head.val);
    ListNode mid = middleNode(head);
    System.out.println("mid ==" + mid.val);
    ListNode rightHead = mid.next;
    //断开链表
    mid.next = null;
    //递归
    ListNode left = sortList_1(head);//将左半部分排序
    ListNode right = sortList_1(rightHead);//将右半部分排序
    //合并
    return mergeNode(left, right);
  }

  private ListNode middleNode(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private ListNode mergeNode(ListNode p, ListNode q) {
    ListNode pre = new ListNode(-1), dummy = pre;
    while (p != null && q != null) {
      if (p.val < q.val) {
        pre.next = p;
        p = p.next;
      } else {
        pre.next = q;
        q = q.next;
      }
      pre = pre.next;
    }

    pre.next = p == null ? q : p;

    return dummy.next;

  }


  public static void main(String args[]) {
    ListNode l1 = new ListNode(4);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(1);
    ListNode l4 = new ListNode(3);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l1.printNode();
    _148_SortList sortList = new _148_SortList();
    ListNode node = sortList.sortList_1(l1);
    node.printNode();

  }
}
