package com.jep.github.swordForOffer;

/**
 * author jiangenping
 * 2019/12/7 下午2:28
 */
// 在O(1)时间删除链表结点
// 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。 这道题很傻比，尾节点用java语言无法清空。
//    A -> B -> C -> D
//    A -> B -> D(new) -> D(original)
public class _18_DeleteNodeInList {

    public static void deleteNode(ListNode first, ListNode toBeDel) {
        if (first == null || toBeDel == null) {
            return;
        }
        //如果是头结点,则移动头部指针
        if (toBeDel == first) {
            first = first.next;
        }
        //如果不是最后一个节点
        if (toBeDel.next != null) {
            ListNode p = toBeDel.next;
            //让当前节点的值和next等于下一个节点
            toBeDel.val = p.val;
            toBeDel.next = p.next;
        } else {
            //如果是最后一个节点 只能遍历
            ListNode cur = first;
            while (cur.next != toBeDel) {
                cur = cur.next;
            }
            cur.next = null;
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
        root.next.next.next.val = 4;
        root.next.next.next.next = new ListNode();
        root.next.next.next.next.val = 5;
        root.printNode();
//        deleteNode(root, root);
//        root.printNode();
//        deleteNode(root, root.next);
//        root.printNode();
        deleteNode(root, root.next.next.next.next);
        root.printNode();


    }
}
