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
    if (head == null) {
      return true;
    }
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

  public static boolean isPalindrome_O1(ListNode head) {
    if (head == null) {
      return true;
    }

    // Find the end of first half and reverse second half.
    ListNode firstHalfEnd = endOfFirstHalf(head);
    ListNode secondHalfStart = reverse(firstHalfEnd.next);

// Check whether or not there is a palindrome.
    ListNode p1 = head;
    ListNode p2 = secondHalfStart;
    boolean result = true;
    while (result && p2 != null) {
      if (p1.val != p2.val) {
        result = false;
      }
      p1 = p1.next;
      p2 = p2.next;
    }

    // Restore the list and return the result.
    firstHalfEnd.next = reverse(secondHalfStart);
    return result;


  }

  public static ListNode endOfFirstHalf(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static ListNode reverse(ListNode head) {
    ListNode pre = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;

  }

  public static void main(String args[]) {

    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(2);
    ListNode node5 = new ListNode(1);
    ListNode node6 = new ListNode(6);
    node6.next = new ListNode(7);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
//    node5.next = node6;

    reverse(node1).printNode();

    System.out.println(isPalindrome_O1((node1)));
    System.out.println(isPalindrome_O1((node6)));

  }

}
