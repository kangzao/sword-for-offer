package com.jep.github.swordForOffer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2021-06-25 9:04 上午
 */
public class _225_MyStack {

  Queue<Integer> queue;
  Queue<Integer> helpQueue;

  /**
   * Initialize your data structure here.
   */
  public _225_MyStack() {
    queue = new LinkedList<>();//存放元素
    helpQueue = new LinkedList<>();//辅助队列
  }

  /**
   * Push element x onto stack.
   */
  public void push(int x) {

    helpQueue.offer(x);
    while (!queue.isEmpty()) {
      helpQueue.offer(queue.poll());
    }
    Queue<Integer> tmp = queue;
    queue = helpQueue;
    helpQueue = tmp;
  }

  /**
   * Removes the element on top of the stack and returns that element.
   */
  public int pop() {
    return queue.poll();
  }

  /**
   * Get the top element.
   */
  public int top() {
    return queue.peek();
  }

  /**
   * Returns whether the stack is empty.
   */
  public boolean empty() {
    return queue.isEmpty();
  }

}
