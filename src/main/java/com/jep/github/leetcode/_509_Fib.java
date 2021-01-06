package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-06 3:30 下午
 */
public class _509_Fib {

  public int fib(int N) {
    if (N < 1) {
      return 0;
    }
    if (N == 1 || N == 2) {
      return 1;
    }
    int pre = 1, curr = 1;
    int sum = 0;
    for (int i = 3; i <= N; i++) {
      sum = pre + curr;
      pre = curr;
      curr = sum;
    }
    return sum;
  }

}
