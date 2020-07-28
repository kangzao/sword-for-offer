package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-27 2:16 PM
 */
public class _053_MaxSubArray {


  public static int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int sum = nums[0];
    int result = sum;
    for (int i = 1; i < nums.length; i++) {
      if (sum > 0) {
        sum += nums[i];
      } else {
        sum = nums[i];
      }
      result = Math.max(result, sum);
    }
    return result;
  }

  public static void main(String args[]) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] nums1 = {1};
    //  Output: 6
    //  Explanation: [4,-1,2,1] has the largest sum = 6.
    System.out.println(maxSubArray(nums1));

  }
}
