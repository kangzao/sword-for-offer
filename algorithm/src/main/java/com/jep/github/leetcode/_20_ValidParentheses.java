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
    if (s == null || s.length() % 2 == 1) {
      return false;
    }
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    Deque<Character> deque = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      //右半边括号需要判断是否闭合
      if (map.containsKey(c)) {
        if (deque.isEmpty() || deque.removeFirst() != map.get(c)) {
          return false;
        }
      } else {
        //如果是左半边的符号，则放入栈顶
        deque.addFirst(c);
      }
    }
    return deque.isEmpty();

  }


  public static void main(String[] args) {
    String str = "()[]{}";
    System.out.println(isValid(str));
  }

}



