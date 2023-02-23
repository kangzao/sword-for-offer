package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-14 3:08 下午
 */
public class _202_IsHappy {

  public boolean isHappy(int n) {
    //fast和fast不能相等，否则while循环不执行！
    int slow = n;
    int fast = getNext(n);
    //如果有环一定会相遇,要么相遇，要么fast到达1
    while (fast != 1 && slow != fast) {
      slow = getNext(slow);
      fast = getNext(getNext(fast));
    }
    return fast == 1;
  }

  public int getNext(int n) {
    int result = 0;
    while (n > 0) {
      int a = n % 10;
      result += a * a;
      n = n / 10;
    }
    return result;
  }
}
