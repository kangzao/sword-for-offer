package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-14 4:25 下午
 */
public class _204_CountPrimes {

  public int countPrimes(int n) {
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) {
        count++;
      }
    }
    return count;
  }

  //判断是否是质数
  public boolean isPrime(int n) {
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}
