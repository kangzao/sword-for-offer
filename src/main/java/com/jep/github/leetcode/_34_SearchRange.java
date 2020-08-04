package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-08-03 10:25 AM
 */
public class _34_SearchRange {

  public static int[] searchRange(int[] nums, int target) {
    int first = findFirst(nums, target);
    int last = findLast(nums, target);
    return new int[]{first, last};

  }

  public static int findFirst(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else {
        //即便查到了，也不返回，缩小右侧边界。
        right = mid - 1;
      }
    }
    //left可能存在越界也可能根本没有移动
    if (left >= nums.length || nums[left] != target) {
      return -1;
    }
    return left;
  }

  public static int findLast(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] <= target) {
        //左侧区间变小，不停靠近右侧
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    //right可能存在越界或者没有移动，由于是取右边界，左侧边界不用考虑
    if (right < 0 || nums[right] != target) {
      return -1;
    }
    return right;
  }

  public static void main(String args[]) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 5;
    System.out.println(findFirst(nums, target));

//    输入: nums = [5,7,7,8,8,10], target = 8
//    输出: [3,4]
//
//    输入: nums = [5,7,7,8,8,10], target = 6
//    输出: [-1,-1]
  }

}
