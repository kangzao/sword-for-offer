package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-01 3:47 下午
 */
public class _191_HammingWeight {

  public int hammingWeight(int n) {
    int result = 0;
    while (n != 0) {
      n &= n - 1;
      result++;
    }
    return result;
  }

}
