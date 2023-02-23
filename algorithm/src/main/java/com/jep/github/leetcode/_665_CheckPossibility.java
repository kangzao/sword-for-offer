package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-27 10:15 AM
 */
public class _665_CheckPossibility {

  public static boolean checkPossibility(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] <= nums[i]) {
        continue;
      }
      count++;
      if (count > 1) {
        return false;
      }
      //根据大小关系判断修改nums[i]或者修改nums[i-1]
      //6 7 1 7 8
      if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
        nums[i] = nums[i - 1];
      } else {
        //  6 5 6 7 8
        nums[i - 1] = nums[i];
      }
    }
    return true;
  }


  public static void main(String args[]) {
    int[] nums = {4, 2, 3};
    System.out.println(checkPossibility(nums));
  }

}
