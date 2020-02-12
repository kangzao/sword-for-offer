package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/*
 * @author: enping.jep
 * @date: 2020/2/5
 * @create 2020-02-05 12:49 PM
 */
public class _283_MoveZeroes {


  public static void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    int insertPos = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[insertPos++] = num;
      }
    }
    Util.printArray(nums);

    while (insertPos < nums.length) {
      nums[insertPos++] = 0;
    }
  }

  public static void main(String args[]) {
    int array[] = {0, 1, 0, 3, 12};
    moveZeroes(array);
    Util.printArray(array);
  }

}
