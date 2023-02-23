package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-02-12 1:38 PM
 *
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

    注意：给定 n 是一个正整数。
 */
public class _70_ClimbStairs {

  //直接递归
  public static int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }

    //当n=3，可以从第一级台阶跨两步，也可以从第二级台阶跨一步
    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  //循环
  public static int climbStairs_loop(int n) {
    int step_1 = 1;
    int step_2 = 2;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = step_1 + step_2;
      step_1 = step_2;
      step_2 = result;
    }
    return result;
  }

  //记忆化递归
  public static int climbStairs_recursion(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    int memo[] = new int[n + 1];
    memo[n] = climbStairs_recursion(n - 1) + climbStairs_recursion(n - 2);
    return memo[n];
  }

  //动态规划
  public static int climbStairs_dp(int n) {
    if (n == 1) {
      return 1;
    }
    int dp[] = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }


  public static void main(String args[]) {
    System.out.println(climbStairs(3));
    System.out.println(climbStairs(5));

    System.out.println(climbStairs_loop(3));
    System.out.println(climbStairs_loop(5));
    System.out.println(climbStairs_loop(6));

    System.out.println(climbStairs_recursion(3));
    System.out.println(climbStairs_recursion(5));
    System.out.println(climbStairs_recursion(6));

    System.out.println(climbStairs_dp(3));
    System.out.println(climbStairs_dp(5));
    System.out.println(climbStairs_dp(6));

  }

}
