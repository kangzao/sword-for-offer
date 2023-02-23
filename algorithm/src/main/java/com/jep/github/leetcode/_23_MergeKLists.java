package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2021-05-11 3:23 下午
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
  输出：[1,1,2,3,4,4,5,6]
  解释：链表数组如下：
  [
    1->4->5,
    1->3->4,
    2->6
  ]
  将它们合并到一个有序链表中得到。
  1->1->2->3->4->4->5->6


 */
public class _23_MergeKLists {

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode ans = null;
    for (int i = 0; i < lists.length; i++) {
      ans = mergeTwoLists(ans, lists[i]);
    }
    return ans;
  }


  public ListNode mergeTwoLists(ListNode a, ListNode b) {
    if (a == null || b == null) {
      return a == null ? b : a;
    }
    ListNode head = new ListNode(0);
    ListNode nodeA = a, nodeB = b, tail = head;

    while (nodeA != null && nodeB != null) {
      if (nodeA.val < nodeB.val) {
        tail.next = nodeA;
        nodeA = nodeA.next;
      } else {
        tail.next = nodeB;
        nodeB = nodeB.next;
      }
      tail = tail.next;
    }
    tail.next = (nodeA == null ? nodeB : nodeA);
    return head.next;
  }

}
