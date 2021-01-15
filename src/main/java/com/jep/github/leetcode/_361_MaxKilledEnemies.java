package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-14 9:11 上午

输入:
grid =[
     "0E00",
     "E0WE",
     "0E00"
]
输出: 3
解释:
把炸弹放在 (1,1) 能杀3个敌人


输入:
grid =[
     "0E00",
     "EEWE",
     "0E00"
]
输出: 2
解释:
P把炸弹放在 (0,0) 或 (0,3) 或 (2,0) 或 (2,3) 能杀2个敌人

注意事项:
你只能在空的地方放置炸弹.
思路是动态规划。我们可以按照四个方向依次求每个位置放炸弹的话能炸死多少敌人。
由于炸弹炸到一个位置的时候，它可以继续向相同的方向走。
up[i][j]表示如果炸弹爆炸经过A[i][j]时，向上的方向能炸死多少敌人(a[i][j]到a[0][j])
UP[i][j] = 0,如果A[i][j]=W
UP[i][j] = UP[i−1][j],如果A[i][j]=0
UP[i][j] = UP[i−1][j] + 1,如果A[i][j]= E

*
*
*/
public class _361_MaxKilledEnemies {


  public int maxKilledEnemies(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int m = grid.length;
    int n = grid[0].length;

    if (n == 0) {
      return 0;
    }
    //经过grid[i][j]且方向向上时
    int[][] up = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 'E') {
          up[i][j] = 1;
        }
        if (i >= 1) {
          if (grid[i][j] == '0') {
            up[i][j] = up[i - 1][j];
          }
          if (grid[i][j] == 'E') {
            up[i][j] = up[i - 1][j] + 1;
          }
        }
      }
    }

    //经过grid[i][j]且方向向下时，要倒着遍历，从最底部开始遍历
    int[][] down = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 'E') {
          down[i][j] = 1;
        }
        if (i >= 1) {
          if (grid[i][j] == '0') {
            down[i][j] = down[i - 1][j];
          }
          if (grid[i][j] == 'E') {
            down[i][j] = down[i - 1][j] + 1;
          }
        }
      }
    }

    return 0;
  }

  public static void main(String args[]) {
    char[][] array = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
    /**
     最好画出四个方向的矩阵,比如up方向,有助于理解运算过程
     {{'0', '1', '0', '0'}, {'1', '1', '0', '1'}, {'1', '2', '0', '1'}}
     **/
    _361_MaxKilledEnemies solution = new _361_MaxKilledEnemies();
    solution.maxKilledEnemies(array);
  }

}
