package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-15 7:23 下午
 */
public class _162_FindPeakElement {


  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return 0;
    }
    int left = 0, right = nums.length - 1;
    ;
    //没有重复元素，递增和递减的情况可能交替出现
    //left和right如果相等，则直接返回，该题一定会有解 不能写等于，否则mid+1会溢出
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[mid + 1]) {
        //下降区，说明峰值在mid左侧，或者就是mid
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;//返回left和right都一样，因为最终会重合在一起。
  }
}
