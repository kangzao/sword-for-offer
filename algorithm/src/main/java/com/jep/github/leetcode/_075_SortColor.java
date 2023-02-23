package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/*
 * @author: enping.jep
 * @create: 2020-07-21 10:50 AM
 */
public class _075_SortColor {


  public static void sortColors(int[] nums) {
    int left = 0, right = nums.length - 1;
    for (int i = left; i < right; ) {
      if (nums[i] == 0) {
        Util.swap(nums, i, left);
        left++;
        i++;
      } else if (nums[i] == 2) {
        Util.swap(nums, i, right);
        right--;
      } else {
        i++;
      }
    }
  }


  public static void main(String args[]) {
    int nums[] = {2, 0, 2, 1, 1, 0};
    sortColors(nums);
    Util.printArray(nums);
  }

}
