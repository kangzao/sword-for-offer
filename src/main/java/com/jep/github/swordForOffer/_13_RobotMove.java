package com.jep.github.swordForOffer;

/**
 * author jiangenping 2019/12/1 下午2:30
 */

// 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
// 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
// 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
// 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
public class _13_RobotMove {

  /**
   * @param rows 行数
   * @param cols 列数
   * @param threshold 阈值
   */

  public static int movingCount(int threshold, int rows, int cols) {
    // 参数校验
    if (threshold < 0 || rows < 1 || cols < 1) {
      return 0;
    }

    // 变量初始化
    boolean[] visited = new boolean[rows * cols];

    return movingCountCore(threshold, rows, cols, 0, 0, visited);
  }


  /**
   * 递归回溯方法
   *
   * @param threshold 约束值
   * @param rows 方格的行数
   * @param cols 方格的列数
   * @param row 当前处理的行号
   * @param col 当前处理的列号
   * @param visited 访问标记数组
   * @return 最多可走的方格
   */
  private static int movingCountCore(int threshold, int rows, int cols,
      int row, int col, boolean[] visited) {

    int count = 0;

    if (col >= 0 && col < cols
        && row >= 0 && row < rows
        && !visited[row * cols + col]
        && (getDigitSum(col) + getDigitSum(row) <= threshold)) {
      visited[cols * row + col] = true;
      return 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +
          movingCountCore(threshold, rows, cols, row, col + 1, visited) +
          movingCountCore(threshold, rows, cols, row + 1, col, visited) +
          movingCountCore(threshold, rows, cols, row, col - 1, visited);

    }

    return count;


  }


  /**
   * 一个数字的数位之和
   *
   * @param number 数字
   * @return 数字的数位之和
   */
  private static int getDigitSum(int number) {
    int result = 0;
    while (number > 0) {
      result += (number % 10);
      number /= 10;
    }

    return result;
  }



  public static void main(String[] args) {
    System.out.println(movingCount(5, 10, 10) + "--21");
    System.out.println(movingCount(15, 20, 20) + "--359");
    System.out.println(movingCount(10, 1, 100) + "--29");
    System.out.println(movingCount(10, 1, 10) + "--10");
    System.out.println(movingCount(15, 100, 1) + "--79");
    System.out.println(movingCount(15, 10, 1) + "--10");
    System.out.println(movingCount(5, 10, 10) + "--21");
    System.out.println(movingCount(12, 1, 1) + "--1");
    System.out.println(movingCount(-10, 10, 10) + "--0");
  }
}
