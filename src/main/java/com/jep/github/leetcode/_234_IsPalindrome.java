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
    ListNode slow = head, fast = head;
    //fast走到尾部，slow走到中间
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    // 1 2 2 1  fast指向null slow指向倒数第二个位置
    // 1 2 3 2 1 奇数个节点，fast指向最后一个位置，slow指向3
    if (fast != null) {
      //奇数个节点，slow往后移动，因为3这个节点可以不用比较
      slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    while (slow != null) {
      if (fast.val != slow.val) {
        return false;
      }
      slow = slow.next;
      fast = fast.next;
    }
    return true;


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
