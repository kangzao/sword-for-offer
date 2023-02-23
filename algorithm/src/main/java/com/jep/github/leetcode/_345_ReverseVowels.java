package com.jep.github.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/*
 * @author: enping.jep
 * @create: 2020-07-01 9:53 AM
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 输入: "hello"
   输出: "holle"
 */
public class _345_ReverseVowels {

  private final static HashSet<Character> vowels = new HashSet<>(
      Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

  public static String reverseVowels(String s) {
    char[] result = s.toCharArray();
    int start = 0, end = s.length() - 1;
    while (start < end) {
      Character swap;
      if (!vowels.contains(result[start])) {
        start++;
      } else if (!vowels.contains(result[end])) {
        end--;
      } else {
        swap = result[start];
        result[start] = result[end];
        result[end] = swap;
        start++;
        end--;
      }

    }
    return new String(result);
  }

}
