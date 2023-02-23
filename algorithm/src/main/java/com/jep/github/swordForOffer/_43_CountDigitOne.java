package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2020-09-18 4:16 PM
 */
public class _43_CountDigitOne {


  public static int countDigitOne(int n) {
    //以534举例，个位数：出现的次数为53+1=54(数字从1增长到530，个位数要经历53次个1，因为4>1，因此最后的结果是53+1)
    //十位数：增长顺序为10-19 110-119 210-219 310-319 410-419 510-519 共有(5+1)*10个1(504有5*10个1，514有5*10+1+4=55个1）
    if (n <= 0) {
      return 0;
    }
    int base = 1;//基准值

    int low = 0;
    int result = 0;
    int high = n / 10;
    int cur = n % 10;

    while (high != 0 || cur != 0) {
      if (cur == 0) {
        result += high * base;
      } else if (cur == 1) {
        result += high * base + 1 + low;
      } else {
        result += (high + 1) * base;
      }

      low += cur * base;
      cur = high % 10;
      high /= 10;
      base *= 10;
    }
    return result;
  }


  public static void main(String args[]) {
    System.out.println(countDigitOne(12));

  }

}
