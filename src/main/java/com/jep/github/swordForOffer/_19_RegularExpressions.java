package com.jep.github.swordForOffer;

/**
 * author jiangenping 2019/12/24 下午8:43
 */

// 正则表达式匹配
// 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
// 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
// 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
// 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
public class _19_RegularExpressions {

  public static boolean match(String str, String pattern) {
    if (str == null || pattern == null) {
      return false;
    }
    return matchCore(str, 0, pattern, 0);
  }

  public static boolean matchCore(String str, int strIndex, String pattern, int patternIndex) {
    // 字符串和模式串都运行到了结尾，返回true
    if (str.length() == strIndex && pattern.length() == patternIndex) {
      return true;
    }
    // 字符串没有到结尾，模式串到了，则返回false
    if (pattern.length() == patternIndex && strIndex != str.length()) {
      return false;
    }

    char strChar = str.charAt(strIndex);
    char patternChar = pattern.charAt(patternIndex);
    // 模式串没到结尾，字符串到了，则继续判断，需要对*进行处理  abc abcc*
    // 模式串的下一个字符是*
    if (pattern.charAt(patternIndex + 1) == '*') {
      // 如果字符串和模式串相等，或者模式串是'.'，并且字符串没有到结尾，则继续匹配 ab a*  bbbba .*aaa*
      if (strChar == patternChar || (patternChar == '.' && strIndex != str.length() - 1)) {
        // 进入下一个状态，就是匹配到了一个 abdca a*cde
        return matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
            // 保持当前状态，就是继续拿这个'*'去匹配  aadca a*cde
            matchCore(str, strIndex + 1, pattern, patternIndex) ||
            // 跳过这个'*'   badb .*a*ab
            matchCore(str, strIndex, pattern, patternIndex + 2);
      }
      // 如果字符串和模式串不相等，则,跳过当前模式串的字符和'*'，进入新一轮的匹配
    } else {
      // 跳过这个'*' 无论字符串和模式串当前字符相不相等，我们都将模式串后移两个字符，相当于把模式串中的当前字符和'*'忽略掉，因为'*'可以匹配任意次的字符，所以出现0次也可以
      return matchCore(str, strIndex, pattern, patternIndex + 2);
    }
    if (strChar == patternChar || (patternChar == '.' && strIndex != str.length() - 1)) {
      return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(match("", ""));
    System.out.println(match("aaa","a.a"));//true
    System.out.println(match("aaa","ab*ac*a"));//true
    System.out.println(match("aaa","aa.a"));//false
    System.out.println(match("aaa","ab*a"));//false
  }
}
