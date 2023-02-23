package com.jep.github.swordForOffer;

/**
 * author jiangenping 2019/12/7 下午12:06
 */

// 17：打印1到最大的n位数
// 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
// 打印出1、2、3一直到最大的3位数即999。
// 核心问题是大数问题，牵涉到大数问题我们可以将其转化为字符串表示。
public class _17_Print1ToMaxOfNDigits {

  public static void print1ToMaxOfNDigits(int n) {
    if (n <= 0) {
      return;
    }
    char[] number = new char[n];
    //给number数组赋初值0
    for (int i = 0; i < n; i++) {
      number[i] = '0';
    }
    while (!increment(number)) {
      printNumber(number);
    }
  }

  public static boolean increment(char[] number) {
    int length = number.length;
    int carryOver = 0;//进位
    boolean isOverFlow = false;
    for (int i = length - 1; i >= 0; i--) {
      //数字的最低位
      int sum = number[i] - '0' + carryOver;
      if (i == length - 1) {
        sum++;
      }
      //产生进位
      if (sum >= 10) {
        //已经到达最高位
        if (i == 0) {
          isOverFlow = true;
        } else {
          //没有到达最高位
          carryOver = 1;
          number[i] = (char) ((sum - 10) + '0');
        }
      } else { //没有进位
        number[i] = (char) ('0' + sum);
        break;
      }
    }
    return isOverFlow;
  }

  //加法如果溢出返回true
//    public static boolean overFlow(char[] numbers, int n) {
//        for (int i = numbers.length - 1; i >= 0; i--) {
//
//        }
//    }

  public static void printNumber(char[] number) {
    boolean flag = false;//是否打印0
    for (int i = 0; i < number.length; i++) {
      if (flag) {
        System.out.print(number[i]);
      } else {
        if (number[i] != '0') {
          flag = true;
          System.out.print(number[i]);
        }
      }
    }
    System.out.println();

  }

  public static void main(String[] args) {
    print1ToMaxOfNDigits(2);

//        System.out.println('1' - '0' + 0);
  }
}
