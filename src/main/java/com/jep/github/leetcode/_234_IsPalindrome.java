package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;
import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-06-28 2:53 PM
 */
public class _234_IsPalindrome {

  public static boolean isPalindrome(ListNode head) {
    List<Integer> list = new ArrayList<Integer>();

    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    int slow = 0;
    int fast = list.size() - 1;

    while (fast > slow) {
      if (!list.get(fast).equals(list.get(slow))) {
        return false;
      }
      fast--;
      slow++;
    }
    return true;

  }

  public static void main(String args[]) {
    ListNode node1 = new ListNode(-129);

    node1.next = new ListNode(-129);

    System.out.println(isPalindrome(node1));

  }

}
