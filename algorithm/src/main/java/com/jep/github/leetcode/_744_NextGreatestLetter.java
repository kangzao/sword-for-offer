package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-29 10:49 AM
 */
public class _744_NextGreatestLetter {

  public static char nextGreatestLetter(char[] letters, char target) {
    int left = 0, right = letters.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (letters[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid;
      }

    }
    return letters[left % letters.length];

  }

  public static void main(String args[]) {
//    letters = ["c", "f", "j"]
//    target = "a"
//    输出: "c"
    char[] letters = {'c', 'f', 'j'};
    char target = 'j';
    System.out.println(nextGreatestLetter(letters, target));

  }

}
