package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/*
 * @author: enping.jep
 * @date: 2020/2/5
 * @create 2020-02-05 12:49 PM
 */
public class _283_MoveZeroes {


  public void moveZeroes_1(int[] nums) {
    //把所有非0元素都移动到左边
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j++] = nums[i];
      }
    }
    //j停留的位置以及之后的位置全部改成0
    for (int i = j; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

  // 双指针法
  public static void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int p = 0;//慢指针 确保慢指针以前的都不是0
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        Util.swap(nums, i, p++);
      }
      Util.printArray(nums);
    }


  }

  public static void main(String args[]) {
    int array[] = {0, 1, 0, 3, 12};
    moveZeroes(array);
    Util.printArray(array);
  }

}
