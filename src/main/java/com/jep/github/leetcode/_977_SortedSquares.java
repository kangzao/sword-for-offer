package com.jep.github.leetcode;

import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2021-04-19 5:14 下午
 */
public class _977_SortedSquares {

  public int[] sortedSquares(int[] nums) {
    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = nums[i] * nums[i];
    }
    Arrays.sort(res);
    return res;
  }


  public int[] sortedSquares_(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int pos = n - 1;
    for (int i = 0, j = n - 1; i <= j; ) {
      if (nums[i] * nums[i] > nums[j] * nums[j]) {
        res[pos] = nums[i] * nums[i];
        i++;
      } else {
        res[pos] = nums[j] * nums[j];
        j--;
      }
      pos--;
    }
    return res;
  }

}
