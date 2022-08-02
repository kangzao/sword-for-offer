package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-08-02 3:05 PM
 */
public class _32_LongestValidParentheses {

  public int longestValidParentheses(String s) {
    int len = s.length();
    int[] dp = new int[len];//dp[i]表示以s[i]结尾的字符串的最大长度
    //s[i]为”(“时，肯定闭合不了，此时dp[i] = 0;
    //s[i]为")"时，有两种情况：
    //一、如果s[i - 1]为"(",dp[i] =  dp[i - 2] + 2;
    /**
     二、如果s[i - 1]为")",需要继续向前找到有没有"("可以和s[i]凑成一对
     int preLen = dp[i - 1] 前面已经形成的有效括号长度
     int pre = s[i - preLen - 1] 寻找与当前的右括号相匹配的左括号位置：前面有效括号长度再往前一个位置
     ( ) ( ( ) ( ) )
     0 1 2 3 4 5 6 7
     dp 0 2 0 0 2 0 4
     dp[6] = dp[6 - 2] + 2 = dp[4] + 2 = 4;
     计算dp[7],计算前面是否有左括号和s[7]匹配
     int pre = i - dp[i - 1] - 1 = 7 - 4 - 1 = 2
     s[2] == ‘(’
     dp[7]分三段，s[7]和s[2]闭合的长度 + dp[i - 1] + dp[pre - 1]
     dp[7] =  2 + dp[6] + dp[1] = 2 + 4 + 2 = 8
     */
    int res = 0;
    for (int i = 1; i < len; i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          if (i >= 2) {
            dp[i] = dp[i - 2] + 2;
          } else {
            dp[i] = 2;//只有两个括号()
          }
        } else {
          int preLen = dp[i - 1];
          int pre = i - preLen - 1;
          if (pre >= 0 && s.charAt(pre) == '(') {
            dp[i] = dp[i - 1] + 2;
            if (pre - 1 >= 0) {
              dp[i] += dp[pre - 1];
            }
          }

        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }

  public static void main(String args[]){
    String s = "()()))))()()(";
    _32_LongestValidParentheses lvp = new _32_LongestValidParentheses();
    lvp.longestValidParentheses(s);
  }

}
