package com.jep.github.supply;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-08-13 3:12 下午
 * 一个链表奇数位上升序，偶数位上降序，不用额外空间让这个链表整体升序，例如：1 8 3 6 5 4 7 2 9，最后输出1 2 3 4 5 6 7 8 9
 */
public class _02_SortList {

  class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
  }

  public void test() {
    //测试 1-8-3-6-5-4-7-2-9
    ListNode l9 = new ListNode(9);
    ListNode l2 = new ListNode(2, l9);
    ListNode l7 = new ListNode(7, l2);
    ListNode l4 = new ListNode(4, l7);
    ListNode l5 = new ListNode(5, l4);
    ListNode l6 = new ListNode(6, l5);
    ListNode l3 = new ListNode(3, l6);
    ListNode l8 = new ListNode(8, l3);
    ListNode head = new ListNode(1, l8);
    ListNode ans = sort(head);
    System.out.println(ans);
  }

  public ListNode sort(ListNode head) {
    //第一步 将奇数和偶数分开  1->4->3->2->5   得到 1 3 5   4 2
    ListNode evenNode = head.next, oddNode = head;
    ListNode evenHead = evenNode, oddHead = oddNode;
    while (evenNode != null && oddNode != null && evenNode.next != null) {
      oddNode.next = evenNode.next;
      evenNode.next = evenNode.next.next;
      oddNode = oddNode.next;
      evenNode = evenNode.next;
    }

    //第二步 反转偶数链表  1 3 5   2 4
    evenHead = reverse(evenHead);
    //第三步 合并链表
    mergeListNode(oddHead, evenHead);
    return oddHead;

  }


  public void mergeListNode(ListNode oddHead, ListNode evenHead) {
    ListNode head = oddHead;
    while (evenHead != null && oddHead != null) {
      ListNode evenNext = evenHead.next;
      ListNode oddNext = oddHead.next;
      evenHead.next = oddNext;
      oddHead.next = evenHead;
      evenHead = evenNext;
      oddHead = oddNext;
    }
  }

  public ListNode reverse(ListNode head) {
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