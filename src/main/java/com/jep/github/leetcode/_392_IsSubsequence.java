package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-23 2:07 PM
 */
public class _392_IsSubsequence {

  public static boolean isSubsequence(String s, String t) {
    int index = -1;
    for (char c : s.toCharArray()) {
      index = t.indexOf(c, index + 1);
    }
    if (index == -1) {
      return false;
    }
    return true;

  }

  public static void main(String args[]) {
    String s = "acb";
    String t = "ahbgdc";
    System.out.println(isSubsequence(s, t));

  }
}
