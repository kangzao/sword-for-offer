package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-01 10:54 AM
 */
public class _680_ValidPalindrome {

  public static boolean validPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
      }
    }
    return true;

  }

  public static boolean isPalindrome(String s, int i, int j) {

    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }
    return true;

  }

  public static void main(String args[]) {
    System.out.println(validPalindrome("abca"));
  }

}
