package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/12/5
 * @create 2019-12-05 8:07 PM
 */

//14：剪绳子
// 题目：给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
// 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
// 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
// 时得到最大的乘积18。

public class _14_CuttingRope {

  public static int cuttingRope(int n) {
    if (n == 3 || n == 2) {
      return n - 1;
    }
    int res = 1;
    while (n > 4) {
      n = n - 3;
      res = 3 * res;
    }
    return res * n;
  }

  public static void main(String args[]) {
    System.out.println(cuttingRope(5) + "6");
    System.out.println(cuttingRope(6) + "9");
    System.out.println(cuttingRope(7) + "12");
  }
}
