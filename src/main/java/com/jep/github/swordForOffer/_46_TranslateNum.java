package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2020-09-10 10:36 AM
 */
public class _46_TranslateNum {

  public static int translateNum(int num) {
    String strNum = String.valueOf(num);
    //a是dp[0] b是dp[1]
    int a = 1, b = 1, c = 0;
    for (int i = 2; i <= strNum.length(); i++) {
      String subString = strNum.substring(i - 2, i);
      if (subString.compareTo("10") >= 0 && subString.compareTo("25") <= 0) {
        c = a + b;
      } else {
        c = b;
      }
      a = b;
      b = c;
    }
    return b;
  }


  public static void main(String args[]) {
    int n = 25;
    System.out.println(translateNum(25));

  }

}
