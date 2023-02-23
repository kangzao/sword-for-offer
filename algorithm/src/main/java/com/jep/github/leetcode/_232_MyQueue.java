package com.jep.github.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @author: enping.jep
 * @create: 2021-04-07 2:25 下午
 * 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 */
public class _232_MyQueue {


  /**
   * Initialize your data structure here.
   */
  Deque<Integer> inStack;
  Deque<Integer> outStack;

  public _232_MyQueue() {
    inStack = new LinkedList();
    outStack = new LinkedList();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    inStack.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    //把入栈元素导入到出栈里面，让栈底的元素到栈顶去
    in2out();
    return outStack.pop();
  }

  /**
   * Get the front element.
   */
  public int peek() {
    in2out();
    return outStack.peek();
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return inStack.isEmpty() && outStack.isEmpty();
  }

  public void in2out() {
    if (outStack.isEmpty()) {
      while (!inStack.isEmpty()) {
        outStack.push(inStack.pop());
      }
    }
  }


}
