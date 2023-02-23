package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-06-30 5:20 PM
 */
public class _633_JudgeSquareSum {


  public static boolean judgeSquareSum(int c) {
    int i = 0;
    int j = (int) Math.sqrt(c);
    while (i <= j) {
      int result = i * i + j * j;
      if (result == c) {
        return true;
      }
      if (result > c) {
        j--;
      } else {
        i++;
      }
    }
    return false;
  }

  public static void main(String args[]) {

    System.out.println(judgeSquareSum(5));

  }


}
