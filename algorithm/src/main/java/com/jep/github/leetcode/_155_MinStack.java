package com.jep.github.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * author jiangenping 2020/3/2 下午10:38
 */

public class _155_MinStack {

  Deque<Integer> stack;
  Deque<Integer> minStack;

  /**
   * initialize your data structure here.
   */
  public _155_MinStack() {
    stack = new LinkedList();
    //最小栈中始终记录当前栈对应值的最小值
    minStack = new LinkedList();
    minStack.push(Integer.MAX_VALUE);
  }

  public void push(int val) {
    stack.push(val);
    if (minStack.peek() > val) {
      minStack.push(val);
    } else {
      minStack.push(minStack.peek());
    }
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

  public static void main(String[] args) {
    _155_MinStack minStack = new _155_MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}
