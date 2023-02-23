package com.jep.github.supply;

/*
 * @author: enping.jep
 * @create: 2021-08-05 7:27 下午
 *
 *  一个环上有10个点，编号为0-9，从0点出发，每步可以顺时针到下一个点，也可以逆时针到上一个点，求：经过n步又
    回到0点有多少种不同的走法

    分析：
 *  走两步的有两种 090 010
 *  设dp[i][j]为从0点出发走i步到j点的方案数
 *  则会比较容易理解这题的解法：走n步到0的方案数 = 走n-1步到1的方案数 + 走n-1步到9的方案数。
 *  dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length]
 *
 *  j-1+length是防止j-1=-1
    %length防止j-1+length或者j+1超过数组大小，绕一圈
    求dp[n][0]
 *
 */
public class _01_Find {

  public int find(int n) {
    int length = 10;
    int[][] dp = new int[n + 1][length];
    //走1 2 3 ... n步
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < length; j++) {
        dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length];
      }
    }
    return dp[n][0];

  }

}
