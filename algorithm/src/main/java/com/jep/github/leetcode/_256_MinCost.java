package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-11 6:42 下午
 *
  这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，
  你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小，返回最小的费用。
  费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。

  样例
  样例 1:

  输入: [[14,2,11],[11,14,5],[14,3,10]]
  输出: 10
  解释: 第一个屋子染蓝色，第二个染绿色，第三个染蓝色，最小花费：2 + 5 + 3 = 10.
  样例 2:
  输入: [[1,2,3],[1,4,6]]
  输出: 3
*
*/
public class _256_MinCost {

  public int minCost(int[][] costs) {

    //房子i的最小涂色开销是房子i-1的最小涂色开销，加上房子i本身的涂色开销。但是房子i的涂色方式需要根据房子i-1的涂色方式来确定，
    //所以我们对房子i-1要记录涂三种颜色分别不同的开销，这样房子i在涂色的时候，我们就知道三种颜色各自的最小开销是多少了
    //不确定第i项选择的是什么颜色，要对不同颜色进行枚举
//    因为相邻房子不能同颜色，所以dp[i][0]只能从dp[i-1][1]和dp[i-1][2]变化来，dp[i][1]，dp[i][2]以此类推
    //状态转移方程:
    //dp[i][0] = Math.min(dp[i-1][1]+costs[i][0],dp[i-1][2]+costs[i][0]);
    //dp[i][1] = Math.min(dp[i-1][0]+costs[i][1],dp[i-1][2]+costs[i][1]);
    //dp[i][2] = Math.min(dp[i-1][0]+costs[i][2],dp[i-1][1]+costs[i][2]);

    /**
     算法
     (DP) O(n)O(n)
     dp[i][j]表示第i幢房子涂j的颜色最小的花费总和，即从前一幢房子的状态dp[i-1][k] (k != j)中选一个不同颜色且最小的再加上给第i幢房子涂j颜色的costs。

     初始化状态dp[0][i]=costs[0][i]

     从左往右遍历每一幢房子，计算到该幢房子涂每种颜色的最小花费，状态转移方程是dp[i][j] = min{dp[i-1][k] +costs[i][j]} (k != j)

     答案为到最后一幢房子涂每种颜色花费中的最小值，即min(dp[n-1][k]),k=0,1,2
     */
    if (costs == null) {
      return 0;
    }
    int length = costs.length;
    if (length == 0) {
      return 0;
    }

    int[][] dp = new int[length][3];

    //初始条件
    dp[0][0] = costs[0][0];
    dp[0][1] = costs[0][1];
    dp[0][2] = costs[0][2];

    for (int i = 1; i < length; i++) {
      dp[i][0] = Math.min(dp[i - 1][1] + costs[i][0], dp[i - 1][2] + costs[i][0]);
      dp[i][1] = Math.min(dp[i - 1][0] + costs[i][1], dp[i - 1][2] + costs[i][1]);
      dp[i][2] = Math.min(dp[i - 1][0] + costs[i][2], dp[i - 1][1] + costs[i][2]);
    }
    return Math.min(dp[length - 1][0], Math.min(dp[length - 1][1], dp[length - 1][2]));
  }


  public static void main(String args[]) {
    int[][] costs = new int[][]{{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
    _256_MinCost sol = new _256_MinCost();
    System.out.println(sol.minCost(costs));
  }

}
