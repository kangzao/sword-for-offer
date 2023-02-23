package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/**
 * author jiangenping
 * 2020/2/22 下午3:34
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * To represent a cycle in the given linked list, we use an integer pos which represents the position
 * (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Note: Do not modify the linked list.
 */

public class _143_DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (slow == null) {
                return null;
            }
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;

            //slow和fast相遇，f = s+bN f = 2s  s=bN slow指针走过了圈数的整数倍
            if (slow == fast) {
                //重置fast，fast走a步进环 slow走bN+a后恰好就是相遇点
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode l1 = new ListNode(2);
        l.next = l1;
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ListNode l3 = new ListNode(4);
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        l3.next = l4;
        l4.next = l1;
        System.out.println(detectCycle(l).val);

    }
}
