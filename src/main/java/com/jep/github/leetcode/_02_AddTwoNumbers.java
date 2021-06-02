package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-06-02 11:20 上午
 */
public class _02_AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int value_1 = (l1 == null ? 0 : l1.val);
      int value_2 = (l2 == null ? 0 : l2.val);
      int sum = value_1 + value_2 + carry;

      carry = sum / 10;
      sum = sum % 10;
      cur.next = new ListNode(sum);
      cur = cur.next;

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry == 1) {
      cur.next = new ListNode(carry);
    }
    return dummy.next;
  }

}
