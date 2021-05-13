package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-05-11 3:43 下午
 */
public class _05_LongestPalindrome {

  public String longestPalindrome(String s) {
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      //以i为中心向左右发散，如果是回文字符串，则字符串数量为奇数
      String s1 = expandAroundCenter(s, i, i);
      //以i和i+1为中心向左右发散，如果是回文字符串，则字符串数量为偶数
      String s2 = expandAroundCenter(s, i, i + 1);

      if (s1.length() > res.length()) {
        res = s1;
      }

      if (s2.length() > res.length()) {
        res = s2;
      }
    }
    return res;


  }

  /**
   * @param s 字符串
   * @param left 原始左边界
   * @param right 原始右边界
   * @return 回文串
   */
  private String expandAroundCenter(String s, int left, int right) {
    //当left==right 回文中心是一个字符  回文串的长度是奇数
    //当right == left + 1 回文中心是两个字符 回文串的长度是偶数
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    //左闭右开
    return s.substring(left + 1, right);
  }


}
