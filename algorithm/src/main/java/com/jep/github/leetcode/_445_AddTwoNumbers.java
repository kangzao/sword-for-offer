package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

import java.util.Stack;

/**
 * author jiangenping
 * 2020/6/27 下午8:51
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */

public class _445_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = buildStack(l1);
        Stack<Integer> s2 = buildStack(l2);
        int carry = 0;

        ListNode pre = new ListNode(-1);
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = a + b + carry;
            carry = sum / 10;

            ListNode listNode = new ListNode(sum % 10);
            listNode.next = pre.next;
            pre.next = listNode;
        }
        return pre.next;


    }

    public static Stack<Integer> buildStack(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        return stack;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
        node6.next = node7;

        addTwoNumbers(node1, node5).printNode();
    }

}