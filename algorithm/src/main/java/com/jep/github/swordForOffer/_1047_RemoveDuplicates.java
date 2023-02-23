package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2021-06-30 3:14 下午
 */
public class _1047_RemoveDuplicates {

  public String removeDuplicates(String s) {
    StringBuilder sb = new StringBuilder();//类似于栈
    int top = -1;//栈顶位置的索引
    for (int i = 0; i < s.length(); i++) {
      if (top < 0 || sb.charAt(top) != s.charAt(i)) {
        //元素入栈
        sb.append(s.charAt(i));
        top++;
      } else {
        //栈顶有元素，且和字符串中的字符相等则删除元素
        sb.deleteCharAt(top--);
      }
    }
    return sb.toString();
  }

}
