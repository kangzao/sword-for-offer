package com.jep.github.swordForOffer;

/**
 * author jiangenping
 * 2019/12/19 下午11:32
 */

//链表中倒数第k个结点
// 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
// 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
// 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
// 值为4的结点。
public class _22_KthNodeFromEnd {

    public ListNode kthNodeFromEnd(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
