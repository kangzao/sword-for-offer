package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-11-19 5:04 PM
 */
public class _242_IsAnagram {


  public static boolean isAnagram(String s, String t) {
    int[] array = new int[26];

    if (s.length() != t.length()) {
      return false;
    }

    for (char ch : s.toCharArray()) {
      array[ch - 'a']++;
    }

    for (char ch : t.toCharArray()) {
      array[ch - 'a']--;
    }

    for (int i = 0; i < array.length; i++) {
      if (array[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {
    String s = "aa";
    String t = "bb";
    System.out.println(isAnagram(s, t));

  }

}
