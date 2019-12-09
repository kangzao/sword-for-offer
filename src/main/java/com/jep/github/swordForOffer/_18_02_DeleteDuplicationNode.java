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

    public static ListNode deleteDuplicationNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //当前节点的前一个节点
        ListNode pre = null;
        //当前节点
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            //当前节点和下一个节点值相同
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                // 跳出循环得到的是第一个和cur.val不同的结点
                // pre为空说明头结点就是重复结点，因此需要重新设置头结点
                if (pre == null) {
                    head = cur;
                } else {
                    // 否则cur之前的pre的下一个结点何cur连接
                    pre.next = cur;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;

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
