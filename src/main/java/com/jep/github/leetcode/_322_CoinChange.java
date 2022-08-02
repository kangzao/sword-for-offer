package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-10-14 4:53 PM
 */
public class _322_CoinChange {


  //搜索回溯，由于没有记录中间结果，执行会超时
  public int coinChange_recursion(int[] coins, int amount) {
    int result = Integer.MAX_VALUE;
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    for (int i = 0; i < coins.length; i++) {
      int subResult = coinChange_recursion(coins, amount - coins[i]);
      if (subResult < 0) {
        continue;
      }
      result = Math.min(result, 1 + subResult);
    }
    // 如果没有任何一种硬币组合能组成总金额，返回 -1。
    if (result == Integer.MAX_VALUE) {
      return -1;
    }
    return result;
  }

  public int coinChange_dp(int[] coins, int amount) {
    if (amount < 1) {
      return 0;
    }
    //构建一个数组，表示在amount金额下，最少的硬币数量
    return coinChange_dp_recursion(coins, amount, new int[amount]);
  }


  //动态规划
  public int coinChange_dp_recursion(int[] coins, int amount, int[] count) {
    //amount在每次选择中，都会变化
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    //如果已经计算过值了，直接返回
    if (count[amount - 1] != 0) {
      return count[amount - 1];
    }

    int min = Integer.MAX_VALUE;
    //选择硬币，并计算硬币的最小数量
    for (int i = 0; i < coins.length; i++) {
      int subResult = coinChange_dp_recursion(coins, amount - coins[i], count);
      //我们要取的是最小结果，所以subResult比最小结果还小，则最小结果+1
      if (subResult > 0 && subResult < min) {
        min = subResult + 1;
      }
    }
    //填表
    count[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
    return count[amount - 1];

  }


  /**
   * 动态规划
   *
   *
   * 凑成面值为 11 的最少硬币个数可以由以下三者的最小值得到：
   *
   * 凑成面值为 10 的最少硬币个数 + 面值为 1 的这一枚硬币； 凑成面值为 9 的最少硬币个数 + 面值为 2 的这一枚硬币； 凑成面值为 6 的最少硬币个数 + 面值为 5
   * 的这一枚硬币。 即 dp[11] = min (dp[10] + 1, dp[9] + 1, dp[6] + 1)。
   *
   * 可以直接把问题的问法设计成状态。
   *
   * 第 1 步：定义「状态」。dp[i] ：凑齐总价值 i 需要的最少硬币个数； 第 2 步：写出「状态转移方程」 dp[amount] = min(dp[amount], 1 +
   * dp[amount - coins[i]]) for i in [0, len - 1] if coins[i] <= amount
   */
  public int coinChange_dp_loop(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    // 注意：因为要比较的是最小值，这个不可能的值就得赋值成为一个最大值
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {

        if (coins[j] <= i && dp[i - coins[j]] != amount + 1) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
        }
      }
    }
    if (dp[amount] == amount + 1) {
      dp[amount] = -1;
    }
    return dp[amount];

  }


  public static void main(String args[]) {
    List<String> list = new ArrayList<>();
    list.add("abc");
    list.add("def");
    System.out.println(list);
  }

}
