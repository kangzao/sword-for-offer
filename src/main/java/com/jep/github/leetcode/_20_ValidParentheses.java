package com.jep.github.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * author jiangenping 2020/3/2 下午9:51
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>ø
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 */


public class _20_ValidParentheses {

  public static boolean isValid(String str) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      Character c = str.charAt(i);
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty();
  }


  public boolean isValid_1(String s) {
    int n = s.length();
    //长度必须是偶数
    if (n % 2 == 1) {
      return false;
    }

    Map<Character, Character> map = new HashMap() {{
      put(')', '(');
      put(']', '[');
      put('}', '{');
    }};
    Deque<Character> deque = new LinkedList();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);

      if (map.containsKey(ch)) {
        //队列的头部和新元素能否匹配
        if (deque.peek() != map.get(ch)) {
          return false;
        }
        //如果匹配，则从队列里面移除
        deque.pop();
      } else {
        //放入队列
        deque.push(ch);
      }
    }
    return deque.isEmpty();

  }


  public static void main(String[] args) {
    String str = "()[]{}";
    System.out.println(isValid(str));
  }

}



