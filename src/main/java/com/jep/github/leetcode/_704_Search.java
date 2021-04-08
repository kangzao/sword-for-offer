package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-08 3:49 下午
 */
public class _704_Search {

  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid = 0;
    while (left <= right) {
      mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;

  }

}
