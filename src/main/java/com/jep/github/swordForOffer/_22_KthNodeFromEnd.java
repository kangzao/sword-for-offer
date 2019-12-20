package com.jep.github.swordForOffer;

/**
 * author jiangenping 2019/12/19 下午11:32
 */

//链表中倒数第k个结点
// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。

public class _22_KthNodeFromEnd {

  public static ListNode kthNodeFromEnd(ListNode head, int k) {
    if (head == null || k <= 0) {
      return head;
    }

    //倒数第K个节点与倒数第一个节点相隔K-1个位置，快指针先走k-1步
    ListNode slow = head, fast = head;
    for (int i = 0; i < k - 1; i++) {
      //走了k-1步之后还有节点
      if (fast.next != null) {
        fast = fast.next;
      } else {
        //K太大，链表长度不够
        return null;
      }
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  public static void main(String[] args) {
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
    ListNode node = kthNodeFromEnd(root, 2);
    node.printNode();


  }
}
