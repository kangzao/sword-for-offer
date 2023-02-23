package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-07-03 8:55 AM
 *
 * 输入:
  s = "abpcplea", d = ["ale","apple","monkey","plea"]

  输出:
  "apple"
 *
 */
public class _524_FindLongestWord {

  public static String findLongestWord(String s, List<String> d) {
    String str = "";
    for (int i = 0; i < d.size(); i++) {
      if (!isSubstr(s, d.get(i))) {
        continue;
      }

      if (d.get(i).length() > str.length()) {
        str = d.get(i);
      }

      if (d.get(i).length() == str.length()) {
        str = str.compareTo(d.get(i)) < 0 ? str : d.get(i);
      }

    }
    return str;

  }

  //  通过删除字符串 s 中的一些字符能得到字符串 t，可以认为 t 是 s 的子序列，我们可以使用双指针来判断一个字符串是否为另一个字符串的子序列。
  //  判断target是否是s的子序列
  private static boolean isSubstr(String s, String target) {
    int i = 0, j = 0;
    while (j < target.length() && i < s.length()) {
      if (s.charAt(i) == target.charAt(j)) {
        j++;
      }
      i++;
    }
    return j == target.length();

  }

  public static void main(String args[]) {
    String s = "abpcplea";
    List<String> d = new ArrayList<>();
    d.add("a");
    d.add("b");
    d.add("c");
    System.out.println(findLongestWord(s, d));
  }
}
