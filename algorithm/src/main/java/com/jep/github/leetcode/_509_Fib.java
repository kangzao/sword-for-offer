package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-06 3:30 下午
 */
public class _509_Fib {

  public int fib(int n) {
    if (n < 2) {
      return n;
    }
    int hair = 0, head = 1, curr = 0;
    for (int i = 2; i <= n; i++) {
      curr = hair + head;
      hair = head;
      head = curr;
    }
    return curr;

  }

}
