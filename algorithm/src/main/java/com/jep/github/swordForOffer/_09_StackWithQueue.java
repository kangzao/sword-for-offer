package com.jep.github.swordForOffer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @author: enping.jep
 * @date: 2019/12/17
 * @create 2019-12-17 6:01 PM
 * 用一个队列实现栈
 */
public class _09_StackWithQueue {

  Queue<Integer> queue = new LinkedList<Integer>();

  //出栈
  public Integer pop() {
    if (queue == null) {
      return null;
    }
    if (queue.size() == 1) {
      return queue.poll();
    }
    for (int i = 0; i < queue.size() - 1; i++) {
      queue.offer(queue.poll());
    }
    return queue.poll();
  }

  //入栈
  public void push(Integer integer) {
    queue.offer(integer);
  }

  public static void main(String args[]) {
    _09_StackWithQueue stackWithQueue = new _09_StackWithQueue();
    stackWithQueue.push(1);
    stackWithQueue.push(2);
    stackWithQueue.push(3);
    System.out
        .println(stackWithQueue.pop() + "," + stackWithQueue.pop() + "," + stackWithQueue.pop());


  }
}
