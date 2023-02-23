package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-03-22 4:45 下午
 */
public class _132_MinCut {

  public int minCut(String s) {
    int len = s.length();
    //判断从i到j这个区间是否是回文字符串
    boolean[][] dp = new boolean[len][len];
    /**
     dp[i][j]的值依赖于dp[i+1][j-1]，因此i要从大到小遍历，j要从小到大遍历
     0  1  2  3  4
     i\j | a  b  b  a  c
     --------------------
     0 a | T  F  F  T  F
     1 b | F  T  T  F  F
     2 b | F  F  T  F  F
     3 a | F  F  F  T  F
     4 c | F  F  F  F  T
     **/

    for (int j = 0; j < len; j++) {
      for (int i = j; i >= 0; i--) {
        //只有一个字符
        if (i == j) {
          dp[i][j] = true;
        } else {
          boolean b = s.charAt(i) == s.charAt(j);
          //两个字符,从i到j,所以是j - 1
          if (j - i == 1) {
            dp[i][j] = b;
          } else {
            dp[i][j] = b && dp[i + 1][j - 1];
          }
        }
      }
    }
    /**
     定义数组 array[i]表示从0到i之间的字符串所需的最小切分数
     第一种情况： 0到i恰好不需要切分 aba array[2] = 0
     第二种情况： i这个位置需要单独切分 abac array[3] = array[2] + 1
     第三种情况： i这个位置恰好和此前的某个位置组成回文 dabccb array[5] = array[1] + 1 da的最小切分数+1
     **/
    int[] array = new int[len];
    for (int j = 1; j < len; j++) {
      if (dp[0][j]) {
        array[j] = 0;
      } else {
        array[j] = array[j - 1] + 1;
        for (int i = 1; i < len; i++) {
          if (dp[i][j]) {
            array[j] = Math.min(array[j], array[i - 1] + 1);
          }
        }
      }
    }
    return array[len - 1];
  }


  public static void main(String args[]) {
    _132_MinCut minCut = new _132_MinCut();
    String s = "aab";
    System.out.println(minCut.minCut(s));
  }
}
