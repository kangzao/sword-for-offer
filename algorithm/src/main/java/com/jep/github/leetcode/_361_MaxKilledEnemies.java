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
up[i][j]表示如果炸弹爆炸经过A[i][j]时（别的位置爆炸或者自己爆炸），向上的方向能炸死多少敌人(a[i][j]到a[0][j])
UP[i][j] = 0,如果A[i][j]=W
UP[i][j] = UP[i−1][j],如果A[i][j]=0
UP[i][j] = UP[i−1][j] + 1,如果A[i][j]= E

*
*
*/
public class _361_MaxKilledEnemies {


  public int maxKilledEnemies(char[][] A) {
    if (A == null || A.length == 0 || A[0].length == 0) {
      return 0;
    }

    int m = A.length;
    int n = A[0].length;
    int[][] up = new int[m][n];
    int[][] down = new int[m][n];
    int[][] left = new int[m][n];
    int[][] right = new int[m][n];
    int i, j, t;

    for (i = 0; i < m; ++i) {
      for (j = 0; j < n; ++j) {
        if (A[i][j] == 'W') {
          continue;
        }

        if (A[i][j] == 'E') {
          up[i][j] = 1;
        }

        if (i >= 1) {
          up[i][j] += up[i - 1][j];
        }
      }
    }

    for (i = m - 1; i >= 0; --i) {
      for (j = 0; j < n; ++j) {

        if (A[i][j] != 'W') {
          if (A[i][j] == 'E') {
            down[i][j] = 1;
          }

          if (i + 1 < m) {
            down[i][j] += down[i + 1][j];
          }
        }
      }
    }

    for (i = 0; i < m; ++i) {
      for (j = 0; j < n; ++j) {

        if (A[i][j] != 'W') {
          if (A[i][j] == 'E') {
            left[i][j] = 1;
          }

          if (j - 1 >= 0) {
            left[i][j] += left[i][j - 1];
          }
        }
      }
    }

    for (i = 0; i < m; ++i) {
      for (j = n - 1; j >= 0; --j) {

        if (A[i][j] != 'W') {
          if (A[i][j] == 'E') {
            right[i][j] = 1;
          }

          if (j + 1 < n) {
            right[i][j] += right[i][j + 1];
          }
        }
      }
    }

    int res = 0;
    for (i = 0; i < m; ++i) {
      for (j = 0; j < n; ++j) {
        if (A[i][j] == '0') {
          t = up[i][j] + down[i][j] + left[i][j] + right[i][j];
          if (t > res) {
            res = t;
          }
        }
      }
    }

    return res;
  }

  public static void main(String args[]) {
    char[][] array = {{'0', 'E'}};
    /**
     最好画出四个方向的矩阵,比如up方向,有助于理解运算过程
     {{'0', '1', '0', '0'}, {'1', '1', '0', '1'}, {'1', '2', '0', '1'}}
     **/
    _361_MaxKilledEnemies solution = new _361_MaxKilledEnemies();
    System.out.println(solution.maxKilledEnemies(array));
  }

}
