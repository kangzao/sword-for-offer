package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-03-24 4:56 下午
 */
public class _521_FindLUSlength {

  public int findLUSlength(String a, String b) {
    if (a.equals(b)) {
      return -1;
    }
    return a.length() > b.length() ? a.length() : b.length();
  }


}
