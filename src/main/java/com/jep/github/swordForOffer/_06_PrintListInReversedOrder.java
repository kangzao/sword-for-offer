package com.jep.github.swordForOffer;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @date: 2019/11/27
 * @create 2019-11-27 12:50 PM
 *
 * 从尾到头反过来打印出每个结点的值。
 *
 */
public class _06_PrintListInReversedOrder {


  public static void recursion(ListNode head) {
    if (null == head) {
      return;
    }
    recursion(head.next);
    System.out.println(head.val);


  }


  public static void main(String args[]) {
    ListNode root = new ListNode();
    root.val = 1;
    root.next = new ListNode();
    root.next.val = 2;
    root.next.next = new ListNode();
    root.next.next.val = 3;
    root.next.next.next = new ListNode();
    root.next.next.next.val = 4;
    root.next.next.next.next = new ListNode();
    root.next.next.next.next.val = 5;
    root.printNode();
    recursion(root);


  }
}
