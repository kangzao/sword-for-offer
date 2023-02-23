package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-12 3:08 下午
 */
public class _91_NumDecodings {


  public int numDecodings(String s) {
    char[] array = s.toCharArray();
    int n = array.length;
    int[] dp = new int[n + 1];//前n个字符的解码方式
    dp[0] = 1;//前0个字符有一种解码方式

    for (int i = 1; i <= n; i++) {
      //第i位单独解码
      if (array[i - 1] != '0') {
        dp[i] = dp[i - 1];
      }
      //第i-1位和第i位一起解码
      if (i > 1) {
        //注意，这里必须将char字符进行偏移量的计算，不然 int res = ('1' - '0') * 10 + '2'   res是60
        int item = (array[i - 2] - '0') * 10 + array[i - 1] - '0';
        if (item >= 10 && item <= 26) {
          dp[i] += dp[i - 2];
        }
      }
    }
    return dp[n];
  }


  public static void main(String args[]) {
    _91_NumDecodings solution = new _91_NumDecodings();
    System.out.println(solution.numDecodings("226"));
    System.out.println(('2' - '0') * 10);

  }


}
