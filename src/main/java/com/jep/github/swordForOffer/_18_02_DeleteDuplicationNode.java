package com.jep.github.swordForOffer;

/**
 * author jiangenping
 * 2019/12/7 下午5:05
 */

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 注意重复的结点不保留：并不是将重复结点删除到只剩一个，而是重复结点的全部会被删除。所以
 * 链表1->2->3->3->4->4->5不是1->2->3->4->5
 */
public class _18_02_DeleteDuplicationNode {

    public static void deleteDuplicationNode(ListNode head) {
        ListNode first = head;
        if (head == null || head.next == null) {
            return;
        }
        while (head != null && head.next != null) {
            ListNode cur = head.next;
            if (head.val == cur.val) {
                head.next = cur.next;
            }
            head = head.next;
        }
    }


    public static void main(String[] args) {
        ListNode root = new ListNode();
        root.val = 1;
        root.next = new ListNode();
        root.next.val = 2;
        root.next.next = new ListNode();
        root.next.next.val = 3;
        root.next.next.next = new ListNode();
        root.next.next.next.val = 3;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;
        root.printNode();
        deleteDuplicationNode(root);
        root.printNode();
    }
}
