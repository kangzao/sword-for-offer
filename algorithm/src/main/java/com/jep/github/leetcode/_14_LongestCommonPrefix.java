package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-06-25 10:30 上午
 */
public class _14_LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    //返回cp，cp的默认值是第一个字符串,用第一个字符串一次和后面的字符串进行比较
    String cp = strs[0];
    for (int i = 1; i < strs.length; i++) {
      int j = 0;
      for (; j < cp.length() && j < strs[i].length(); j++) {
        if (cp.charAt(j) != strs[i].charAt(j)) {
          break;
        }
      }
//      如果没有公共部分早点退出
      cp = cp.substring(0, j);
      if (cp.equals("")) {
        return cp;
      }
    }
    return cp;
  }

}
