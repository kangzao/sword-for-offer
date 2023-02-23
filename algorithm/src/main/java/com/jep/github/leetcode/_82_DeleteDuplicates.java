package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-08-16 7:51 下午
 */
public class _82_DeleteDuplicates {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    ListNode pre = new ListNode(-1);
    pre.next = head;
    ListNode dummy = pre;
    while (cur != null) {
      //如果有相同的数字，移动当前指针
      while (cur.next != null && cur.next.val == cur.val) {
        cur = cur.next;
      }
      //如果pre和cur之间没有重复节点
      if (pre.next == cur) {
        pre = pre.next;
      } else {
        //跳过重复节点
        pre.next = cur.next;
      }
      cur = cur.next;
    }
    return dummy.next;
  }


  public static ListNode deleteDuplicates_1(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode pre = new ListNode(-1);
    pre.next = head;
    ListNode dummy = pre;
    ListNode left = head, right = head.next;
    while (right != null) {
      if (left.val != right.val) {
        pre = left;
      } else {
        //
        while (left.val == right.val) {
          right = right.next;
          if (right == null) {
            break;
          }
        }
        pre.next = right;
      }
      left = right;
      right = right.next;
    }
    return dummy.next;
  }

  public static void main(String args[]) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    deleteDuplicates_1(head);
  }
}
