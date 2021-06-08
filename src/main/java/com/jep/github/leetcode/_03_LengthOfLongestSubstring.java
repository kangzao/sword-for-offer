package com.jep.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2021-03-26 3:22 下午
 */
public class _03_LengthOfLongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    //滑动窗口计算
    //开始位置
    int start = 0;
    Map<Character, Integer> map = new HashMap();
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        //移动滑动窗口
        //比如：abb  start会移动到最后一个字母上去，因为有重复，所以要重新指定start的位置
        start = Math.max(start, map.get(c) + 1);
      }
      //记录滑动窗口的起始位置
      map.put(c, i);
      result = Math.max(result, i - start + 1);
    }
    return result;
  }

}
