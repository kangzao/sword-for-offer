package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-29 3:46 下午
 */
public class _33_Search {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return target == nums[0] ? 0 : -1;
    }

    //数组局部有序
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        return mid;
      }
      //判断左半边是不是递增
      if (nums[mid] >= nums[0]) {
        if (target >= nums[0] && target < nums[mid]) {
          //在左半边，减小right
          right = mid - 1;
        } else {
          //不在左半边，说明在右半边 增大left
          left = mid + 1;
        }

      } else {
        //左半边如果不是递增的，则右半边一定是递增的
        //判断是否在右半边
        if (target > nums[mid] && target <= nums[nums.length - 1]) {
          //在右半边，移动左边界
          left = mid + 1;
        } else {
          //在左半边，移动右边界
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}
