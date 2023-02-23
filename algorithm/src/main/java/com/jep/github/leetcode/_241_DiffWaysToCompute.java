package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-08-04 1:54 PM
 */
public class _241_DiffWaysToCompute {

  public static List<Integer> diffWaysToCompute(String input) {

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '+' || c == '-' || c == '*') {
        List<Integer> left = diffWaysToCompute(input.substring(0, i));
        List<Integer> right = diffWaysToCompute(input.substring(i + 1));
        for (Integer l : left) {
          for (Integer r : right) {
            switch (c) {
              case '+':
                list.add(l + r);
                break;
              case '-':
                list.add(l - r);
                break;
              case '*':
                list.add(l * r);
                break;
            }
          }
        }
      }
    }
    if (list.size() == 0) {
      list.add(Integer.valueOf(input));
    }

    return list;
  }


  public static void main(String args[]) {
//    输入: "2*3-4*5"
//    输出: [-34, -14, -10, -10, 10]
    String str = "2*3-4*5";
    System.out.println(diffWaysToCompute(str));


  }

}
