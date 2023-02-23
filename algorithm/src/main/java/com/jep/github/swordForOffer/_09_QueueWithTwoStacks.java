package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/12/17
 * @create 2019-12-17 5:17 PM
 */

import java.util.Deque;
import java.util.LinkedList;
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

  Deque<Integer> inStack, outStack;

  public _09_QueueWithTwoStacks() {
    inStack = new LinkedList();
    outStack = new LinkedList();
  }

  public void appendTail(int value) {
    inStack.push(value);
  }

  public int deleteHead() {
    in2out();
    if (outStack.isEmpty()) {
      return -1;
    }
    return outStack.pop();

  }

  public void in2out() {
    if (outStack.isEmpty()) {
      while (!inStack.isEmpty()) {
        outStack.push(inStack.pop());
      }
    }
  }

}
