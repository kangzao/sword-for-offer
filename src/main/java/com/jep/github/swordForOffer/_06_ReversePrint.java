package com.jep.github.swordForOffer;

import java.util.Stack;

/*
 * @author: enping.jep
 * @create: 2022-03-25 5:52 下午
 */
public class _06_ReversePrint {
  public int[] reversePrint(ListNode head) {
    Stack<ListNode> stack = new Stack();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    int size = stack.size();
    int[] print = new int[size];
    for (int i = 0; i < size; i++) {
      print[i] = stack.pop().val;
    }
    return print;
  }

}
