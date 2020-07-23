package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-23 9:01 AM
 */
public class _121_MaxProfit {

  public static int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int max = 0;
    int min = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      } else {
        max = Math.max(max, prices[i] - min);
      }
    }
    return max;
  }

  public static void main(String args[]) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));
  }

}
