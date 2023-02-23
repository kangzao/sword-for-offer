package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-07-19 4:55 PM
 */
public class _72_MinDistance {
  public int minDistance(String word1, String word2) {
    //dp[i][j] 表示的是word1从[0....i-1] 位置到word2[0...j-1]位置的编辑距离,
    //如果word1[i - 1] == word2[j - 1],则dp[i][j] == dp[i - 1][j - 1];
    //否则有以下几种情况
    //1、删除  hors -> ros,然后删除e  dp[i - 1][j] + 1
    //2、替换  hors -> ro,然后e修改成s dp[i - 1][j - 1] + 1
    //3、插入  horse -> ro,然后插入s dp[i][j - 1] + 1

    int n1 = word1.length(), n2 = word2.length();
    int[][] dp = new int[n1 + 1][n2 + 1];
    //初始化dp[0][j] 和 dp[i][0] word1 = "horse", word2 = "ros"
        /*

           '' r  o  s
        '' 0  1  2  3

        h  1

        o  2

        r  3

        s  4

        e  5
        */
    //第0行
    for(int j = 0; j <= n2; j++) dp[0][j] = j;
    //第0列
    for(int i = 0; i <= n1; i++) dp[i][0] = i;

    //'' h o r s e
    //0  1 2 3 4 5
    for(int i = 1; i <= n1; i++){
      for(int j = 1; j <= n2; j++){
        if(word1.charAt(i - 1) == word2.charAt(j - 1)){
          dp[i][j] = dp[i - 1][j - 1];
        }else{
          dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i - 1][j - 1]),dp[i][j - 1]) + 1;
        }
      }
    }
    return dp[n1][n2];
  }

  public static void main(String args[]){
    _72_MinDistance minDistance = new _72_MinDistance();
    minDistance.minDistance("horse","ros");

  }


}
