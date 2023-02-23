package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-06-25 4:32 下午
 */
public class _344_ReverseString {

  public void reverseString(char[] s) {
    int head = 0, tail = s.length - 1;
    while (head < tail) {
      char tmp;
      tmp = s[head];
      s[head] = s[tail];
      s[tail] = tmp;
      head++;
      tail--;
    }
  }

}
