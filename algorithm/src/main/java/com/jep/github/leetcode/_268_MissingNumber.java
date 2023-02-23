package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-22 6:45 下午
 */
public class _268_MissingNumber {

  public int missingNumber(int[] nums) {
    int sum = nums.length;
    for (int i = 0; i < nums.length; i++) {
      sum += i - nums[i];
    }
    return sum;

  }

}
