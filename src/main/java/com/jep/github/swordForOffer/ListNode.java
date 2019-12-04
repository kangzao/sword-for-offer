package com.jep.github.swordForOffer;

/**
 * 结点对象
 */
public class ListNode {

    int val; // 结点的值
    ListNode next; // 下一个结点


    public static void printNode(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(node.val).append("->");
        ListNode next = node.next;
        while (next != null) {
            stringBuilder.append(next.val).append("->");
            next = next.next;
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
    }
}

