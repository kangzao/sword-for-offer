package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-08-19 4:46 下午
 */
public class _240_SearchMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    //从右上角出发，寻找指定的值，往左会变小，往下会变大
    int row = 0, col = n - 1;
    while (col >= 0 && row <= m - 1) {
      if (matrix[row][col] > target) {
        col--;
      } else if (matrix[row][col] < target) {
        row++;
      } else {
        return true;
      }
    }
    return false;
  }


  public boolean searchMatrix_binary(int[][] matrix, int target) {
    //逐行二分查找
    int m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      //某一行的最小值偏大，则直接退出
      if (matrix[i][0] > target) {
        break;
      }
      //某一行的最后一个元素偏小，这行就可以忽略了
      if (matrix[i][n - 1] < target) {
        continue;
      }
      //二分查找
      if (binarySearch(matrix[i], target) != -1) {
        return true;
      }
    }
    return false;

  }

  private int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

}
