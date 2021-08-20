package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-08-20 11:02 上午
 */
public class _22_GenerateParenthesis {

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    dfs("", 0, 0, n, res);
    return res;

  }

  /**
   * left : 选中的左括弧的数量 right: 选中的右括弧的数量
   */
  public void dfs(String curStr, int left, int right, int n, List<String> res) {
    //递归退出条件
    if (left == n && right == n) {
      res.add(curStr);
      return;
    }

    //减枝 选中的右括弧数量大于左括弧，则无法闭合
    if (right > left) {
      return;
    }
    //左括弧数量不能超过限制
    if (left > n) {
      return;
    }

    System.out.println("before add left :" + curStr);
    //选择左括弧
    dfs(curStr + "(", left + 1, right, n, res);

    System.out.println("before add right :" + curStr);
    //选择右括弧
    dfs(curStr + ")", left, right + 1, n, res);

  }

  public static void main(String args[]) {
    _22_GenerateParenthesis solution = new _22_GenerateParenthesis();
    solution.generateParenthesis(3);
  }

}
