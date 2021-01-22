package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-20 10:50 上午
 *
 *
  这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。每个房屋染不同的颜色费用也不同，你希望每两个相邻的房屋颜色不同，
  但是这样可能会使得成本上升。

  费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，cost[1][2]表示房屋1染颜色2的费用。

  样例
  样例1

  输入:
  costs = [[14,2,11],[11,14,5],[14,3,10]]
  输出: 10
  说明:
  三个屋子分别使用第1,2,1种颜色，总花费是10。
  样例2

  输入:
  costs = [[5]]
  输出: 5
  说明：
  只有一种颜色，一个房子，花费为5
  挑战
  用O(nk)的时间复杂度解决
 */
public class _265_MinCostII {

  /**
   * dp[i][j]表示第i幢房子涂j的颜色最小的总和，即从前一幢房子的状态dp[i-1][k] (k != j)中选一个不同颜色且最小的再加上给第i幢房子涂j颜色的costs。
   *
   * 状态转移方程是dp[i][j] = min{dp[i-1][h] +costs[i][j]} (h != j)
   *
   * 代码思路 初始化状态dp[0][i]=costs[0][i]
   *
   * 从左往右遍历每一幢房子，计算到当前幢房子时，先计算到前一幢房子的最小花费和次小花费，转移时若当前涂的颜色与前一幢房子的最小值涂的颜色不同，
   * 那么到当前房子涂此种颜色的最小花费就是前一幢房子的最小花费加上涂此种颜色的花费，否则就是前一幢房子的次小花费加上涂此种颜色的花费
   *
   * 答案为到最后一幢房子涂每种颜色花费中的最小值，即min(dp[n-1][k])
   */

  public int minCostII(int[][] costs) {
    if (costs == null) {
      return 0;
    }
    if (costs.length == 0 || costs[0].length == 0) {
      return 0;
    }

    int preMin = 0;
    int preSecondMin = 0;
    //前N-1个房子最小花费的索引位置
    int preIndex = -1;

    for (int i = 0; i < costs.length; i++) {
      int curMin = Integer.MAX_VALUE;
      int curSecondMin = Integer.MAX_VALUE;
      int curIndex = 0;
      for (int j = 0; j < costs[0].length; j++) {
        //当前最小值的颜色是否和[0,n-1]所用颜色的最小值一致
        if (j == preIndex) {
          costs[i][j] += preSecondMin;
        } else {
          costs[i][j] += preMin;
        }
        //需要找到每列的最小值和次小值
        if (curMin > costs[i][j]) {
          curSecondMin = curMin;
          curMin = costs[i][j];
          curIndex = j;
        } else if (curSecondMin > costs[i][j]) {
          curSecondMin = costs[i][j];
        }
      }
      preMin = curMin;
      preSecondMin = curSecondMin;
      preIndex = curIndex;
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < costs[0].length; i++) {
      if (result > costs[costs.length - 1][i]) {
        result = costs[costs.length - 1][i];
      }
    }
    return result;
  }

  public static void main(String args[]) {

    System.out.println(100 ^ 100);

  }

}
