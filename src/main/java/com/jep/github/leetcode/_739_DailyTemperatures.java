package com.jep.github.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @author: enping.jep
 * @create: 2021-07-29 8:00 下午
 */
public class _739_DailyTemperatures {

  public int[] dailyTemperatures(int[] temperatures) {
    //队列中存放temperatures的索引 数值大的在栈底
    Deque<Integer> deque = new LinkedList<>();
    int n = temperatures.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekFirst()]) {
        int pre = deque.removeFirst();
        res[pre] = i - pre;
      }
      deque.addFirst(i);
    }
    return res;
  }

}
