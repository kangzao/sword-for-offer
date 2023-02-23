package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/**
 * author jiangenping
 * 2020/6/29 下午9:58
 */

public class _725_SplitListToParts {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        node1.printNode();
        ListNode[] array = splitListToParts(node1, 5);



    }


    public static ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode head = root;
        while (head != null) {
            head = head.next;
            count++;
        }
        int mod = count % k;
        int size = count / k;
        ListNode[] array = new ListNode[k];
        head = root;
        for (int i = 0; i < k && head != null; i++) {
            array[i] = head;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                head = head.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        return array;
    }
}

