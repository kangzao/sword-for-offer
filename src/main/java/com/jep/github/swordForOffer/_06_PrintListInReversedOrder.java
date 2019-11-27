package com.jep.github.swordForOffer;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @date: 2019/11/27
 * @create 2019-11-27 12:50 PM
 *
 * 从尾到头反过来打印出每个结点的值。
 *
 */
public class _06_PrintListInReversedOrder {

  /**
   * 结点对象
   */
  public static class ListNode {

    int val; // 结点的值
    ListNode nxt; // 下一个结点


  }

  public static void printNode(ListNode node) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(node.val).append("->");
    ListNode nxt = node.nxt;
    while (nxt != null) {
      stringBuilder.append(nxt.val).append("->");
      nxt = nxt.nxt;
    }
    System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
  }

  //单链表反转

  //  dummy->1->2->3->4->5的就地反转过程：
  //      dummy->2->1->3->4->5
  //      dummy->3->2->1->4->5
  //      dummy->4>-3->2->1->5
  //      dummy->5->4->3->2->1
  public static ListNode reverse(ListNode head) {
    if (head == null || head.nxt == null) {
      return head;
    }
    //虚拟一个节点指向头部
    ListNode dummy = new ListNode();
    dummy.nxt = head;
    ListNode prev = dummy.nxt;
    ListNode cur = prev.nxt;
    while () {
      cur.nxt = prev;
      prev.nxt = dummy;

    }
    return dummy;
  }

  //递归方法
  public static List<Integer> printListInReversedOrder_recursion(ListNode listNode) {
    List<Integer> list = new ArrayList<Integer>();
    if (listNode != null) {
      list.addAll(printListInReversedOrder_recursion(listNode.nxt));
      list.add(listNode.val);
    }
    return list;
  }


  public static void main(String args[]) {
    ListNode root = new ListNode();
    root.val = 1;
    root.nxt = new ListNode();
    root.nxt.val = 2;
    root.nxt.nxt = new ListNode();
    root.nxt.nxt.val = 3;
    root.nxt.nxt.nxt = new ListNode();
    root.nxt.nxt.nxt.val = 4;
    root.nxt.nxt.nxt.nxt = new ListNode();
    root.nxt.nxt.nxt.nxt.val = 5;

    List<Integer> list = printListInReversedOrder_recursion(root);
    StringBuilder stringBuilder = new StringBuilder();
    for (Integer value : list) {
      stringBuilder.append(value).append("->");
    }
    System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));


  }
}
