package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/11/26
 * @create 2019-11-26 5:48 PM
 *
 *
    给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
    Consider the following matrix:
    [
      [1,   4,  7, 11, 15],
      [2,   5,  8, 12, 19],
      [3,   6,  9, 16, 22],
      [10, 13, 14, 17, 24],
      [18, 21, 23, 26, 30]
    ]

    Given target = 5, return true.
    Given target = 20, return false.
 */
public class _04_FindInPartiallySortedMatrix {

  public static boolean findInPartiallySortedMatrix(int[][] array, int number) {
    // 输入条件判断
    if (array == null || array.length < 1 || array[0].length < 1) {
      return false;
    }

    int rows = array.length;
    int cols = array[0].length;
    int r = 0, c = cols - 1;
    while (r <= rows - 1 && c >= cols - 1) {
      if (array[r][c] == number) {
        return true;
      } else if (array[r][c] > number) {
        r++;
      } else {
        c--;
      }
    }
    return false;
  }


  public static void main(String args[]) {
    int[][] matrix = {
        {1, 2, 8, 9},
        {2, 4, 9, 12},
        {4, 7, 10, 13},
        {6, 8, 11, 15}
    };
    System.out.println(findInPartiallySortedMatrix(matrix, 20));
    System.out.println(findInPartiallySortedMatrix(matrix, 7));    // 要查找的数在数组中
    System.out.println(findInPartiallySortedMatrix(matrix, 5));    // 要查找的数不在数组中
    System.out.println(findInPartiallySortedMatrix(matrix, 1));    // 要查找的数是数组中最小的数字
    System.out.println(findInPartiallySortedMatrix(matrix, 15));   // 要查找的数是数组中最大的数字
    System.out.println(findInPartiallySortedMatrix(matrix, 0));    // 要查找的数比数组中最小的数字还小
    System.out.println(findInPartiallySortedMatrix(matrix, 16));   // 要查找的数比数组中最大的数字还大
    System.out.println(findInPartiallySortedMatrix(null, 16));     // 健壮性测试，输入空指针
  }

}
