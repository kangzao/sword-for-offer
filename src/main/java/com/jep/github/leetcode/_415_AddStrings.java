package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-06 10:56 上午
 */
public class _415_AddStrings {

  public String addStrings(String num1, String num2) {
    int p1 = num1.length() - 1, p2 = num2.length() - 1;
    int add = 0;
    StringBuilder stringBuilder = new StringBuilder();
    while (p1 >= 0 || p2 >= 0) {
      //char转化成int，否则直接输出的是char对应的ascii码值，没有数字则补0
      int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
      int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
      int sum = n1 + n2 + add;
      int result = sum % 10;
      add = sum / 10;
      stringBuilder.append(result);
      p1--;
      p2--;
    }
    if (add > 0) {
      stringBuilder.append(add);
    }
    return stringBuilder.reverse().toString();
  }

  public static void main(String args[]) {
    String num1 = "115";
    String num2 = "29";
    System.out.println(num1.charAt(2));
    _415_AddStrings add = new _415_AddStrings();
    System.out.println(add.addStrings(num1, num2));


  }
}
