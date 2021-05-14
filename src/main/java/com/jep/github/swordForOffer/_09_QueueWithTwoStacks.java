package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/12/17
 * @create 2019-12-17 5:17 PM
 */

import java.util.Stack;

//用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。

/**
 * 示例 1：
 *
 * 输入： ["CQueue","appendTail","deleteHead","deleteHead"] [[],[3],[],[]] 输出：[null,null,3,-1]
 *
 * 示例 2：
 *
 * 输入： ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]] 输出：[null,-1,null,null,5,2]
 */
public class _09_QueueWithTwoStacks {

  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();

  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }
    if (stack2.empty()) {
      throw new IllegalStateException("no more element！");
    }
    return stack2.pop();
  }

  public static void main(String[] args) {
    _09_QueueWithTwoStacks queueWithTwoStacks = new _09_QueueWithTwoStacks();
    queueWithTwoStacks.push(1);
    queueWithTwoStacks.push(2);
    queueWithTwoStacks.push(3);
    queueWithTwoStacks.push(4);
    queueWithTwoStacks.push(6);
    System.out.println(
        queueWithTwoStacks.pop() + "," + queueWithTwoStacks.pop() + "," + queueWithTwoStacks.pop()
            + "," + queueWithTwoStacks.pop() + "," + queueWithTwoStacks.pop());


  }

}
