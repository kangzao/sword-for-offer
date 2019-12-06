package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/12/6
 * @create 2019-12-06 12:30 PM
 *
 */

//10：斐波那契数列
// 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
//1、1、2、3、5、8、13、21、34...
public class _10_Fibonacci {

  //递归法
  public static int fibonacci_recursion(int n) {
    if (n <= 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    } else {
      return fibonacci_recursion(n - 1) + fibonacci_recursion(n - 2);
    }
  }

  //循环法
// 0  1 2  3
// 0、1、1、2、3、5、8、13、21、34...
  public static int fibonacci_loop(int n) {

    int[] result = {0, 1};
    if (n < 2) {
      return result[n];
    }

    int fibNMinusOne = 0;
    int fibNMinusTwo = 1;
    int fibN = 0;
    for (int i = 2; i <= n; i++) {
      fibN = fibNMinusOne + fibNMinusTwo;
      fibNMinusOne = fibNMinusTwo;
      fibNMinusTwo = fibN;
    }
    return fibN;
  }

  public static void main(String args[]) {
    System.out.println(fibonacci_recursion(0) + "--0");
    System.out.println(fibonacci_recursion(5) + "--5");

    System.out.println(fibonacci_recursion(6) + "--8");

    System.out.println(fibonacci_loop(7) + "--13");

    System.out.println(fibonacci_loop(9) + "--34");

  }
}
