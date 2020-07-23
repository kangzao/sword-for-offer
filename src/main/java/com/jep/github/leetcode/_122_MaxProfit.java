package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-23 9:51 AM
 */
public class _122_MaxProfit {

  //  对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
  //  而 d - a = (d - c) + (c - b) + (b - a) ，因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中。
  public static int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      int choice = prices[i] - prices[i - 1];
      if (choice > 0) {
        profit += choice;
      }
    }
    return profit;
  }

  public static void main(String args[]) {
    int array[] = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(array));

//    [7,1,5,3,6,4] 7
//    [1,2,3,4,5] 4

  }

}
