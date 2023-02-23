package com.jep.github.swordForOffer;

/**
 * @author jiangenping
 * @date 2020/9/15 下午8:45
 */
public class _44_FindNthDigit {


  public static int findNthDigit(int n) {

    char res = '0';

    long index = n;
    //左边界
    long border = 0;
    //base表示数字的位数，比如：10的位数是2 1的位数是1
    long base = 1;
    //1-9 有9个数字，10-99 有90个数字
    long digitNum = 9;
    //先求出范围，比如：0123456789101112 求第14位，首先确定第14位的数字是在10-99这个区间内
    //递推公式 border = border + base*digitalNum  1-9这个区间， border是9, 循环执行完border是9
    while (border + base * digitNum < index) {
      border += base * digitNum;
      base += 1;
      digitNum *= 10;
    }
    //border=9则确定14在10-99这个区间内，14-9 = 5, base = 2,5/2 = 2,则该数字在10+2 = 12这个数字中(走过两个数字),5%2 = 1说明在12这个数字中的第一个位置上
    long a = (index - border) / base;
    long b = (index - border) % base;
    //该位置所在的数字是多少
    long c;
    if (b != 0) {
      //没有整除，则走过a个数字，落在12这个位置
      c = (long) (Math.pow(10, base - 1) + a);
      res = String.valueOf(c).charAt((int) b - 1);
    } else {
      //如果恰好整除，走过两个数字之后前移一个数字
      c = (long) (Math.pow(10, base - 1) + a - 1);
      //这个数字的最后一位
      res = String.valueOf(c).charAt((int) base - 1);
    }
    return Integer.parseInt(String.valueOf(res));

  }

  public static void main(String[] args) {
    System.out.println(findNthDigit(3));
  }
}
