package com.jep.github.leetcode;

import java.util.Stack;

/*
 * @author: enping.jep
 * @create: 2021-04-07 2:25 下午
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 */
public class _232_MyQueue {


  Stack<Integer> s1;
  Stack<Integer> s2;

  /**
   * Initialize your data structure here.
   */
  public _232_MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    s1.push(x);

  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    peek();
    return s2.pop();
  }

  /**
   * Get the front element.
   */
  public int peek() {
    if (s2.empty()) {
      while (!s1.empty()) {
        s2.push(s1.pop());
      }
    }
    return s2.peek();
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return s1.empty() && s2.empty();
  }


}
