package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/12/5
 * @create 2019-12-05 9:06 PM
 */

// 二进制中1的个数
// 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
// 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
public class _15_NumberOf1InBinary {

  public static int numberOf1InBinary(int n) {
    int count = 0;
    int compare = 1;
    while (compare != 0) {
      if ((n & compare) != 0) {
        count++;
      }
      compare = compare << 1;
      System.out.println(compare);
    }
    return count;
  }

  public static void main(String args[]) {

    System.out.println(numberOf1InBinary(9));
    System.out.println(numberOf1InBinary(8));
  }
}
