package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-05-14 2:46 下午
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

   返回同样按升序排列的结果链表。
   输入：head = [1,1,2,3,3]
   输出：[1,2,3]
 */
public class _83_DeleteDuplicates {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode pre = head;
    while (head != null && head.next != null) {
      ListNode next = head.next;
      if (head.val == next.val) {
        head.next = next.next;
      } else {
        head = head.next;
      }
    }
    return pre;
  }

}
