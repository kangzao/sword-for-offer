package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-06 10:56 上午
 */
public class _415_AddStrings {

  public String addStrings(String num1, String num2) {

    StringBuilder stringBuilder = new StringBuilder();
    //进位
    int carry = 0;
    int p1 = num1.length() - 1;
    int p2 = num2.length() - 1;
    while (p1 >= 0 || p2 >= 0) {
      char a = p1 < 0 ? '0' : num1.charAt(p1);
      char b = p2 < 0 ? '0' : num2.charAt(p2);
      int sum = (a - '0') + (b - '0') + carry;
      carry = sum / 10;
      stringBuilder.append(sum % 10);
      p1--;
      p2--;
    }
    if (carry == 1) {
      stringBuilder.append(carry);
    }
    return stringBuilder.reverse().toString();
  }

  public static void main(String args[]) {
    String num1 = "115";
    String num2 = "29";
    _415_AddStrings add = new _415_AddStrings();
    System.out.println(add.addStrings(num1, num2));


  }
}
