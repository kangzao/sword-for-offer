package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/*
 * @author: enping.jep
 * @create: 2021-08-04 3:48 下午
 */
public class _518_Change {


  /**
   * 用dp[x] 表示金额之和等于 xx 的硬币组合数，目标是求dp[amount] 对于面额为coin 的硬币，当coin ≤ i ≤ amount
   * 时，如果存在一种硬币组合的金额之和等于i−coin，则在该硬币组合中增加一个面额为coin 的硬币， 即可得到一种金额之和等于 i 的硬币组合。
   * 因此需要遍历coins，对于其中的每一种面额的硬币，更新数组dp 中的每个大于或等于该面额的元素的值。
   */
  public int change(int amount, int[] coins) {

    int[] dp = new int[amount + 1];//金额i的方案数
    // dp[i] += dp[amount - i] //dp[x] 表示金额之和等于 xx 的硬币组合数，目标是求dp[amount]。

    /**
     对amount为5而言
     1结尾 有 {1, 1, 1, 1, 1}
     2结尾 有 {1, 1, 1, 2},  {1, 2, 2}
     3结尾 有 {1, 1, 3}, {2, 3}
     */
    dp[0] = 1;
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= amount; j++) {
        dp[j] += dp[j - coins[i]];
        System.out.println("j = " + j + ",dp[j] = " + dp[j]);
      }
    }
    Util.printArray(dp);
    return dp[amount];
  }

  public static void main(String args[]) {
    int amount = 5;
    int[] coins = {1, 2, 5};
    _518_Change solution = new _518_Change();
    solution.change(amount, coins);
  }

}
