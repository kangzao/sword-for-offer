package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-20 6:16 下午
 */
public class _287_FindDuplicate {

  public static int findDuplicate(int[] nums) {

    // 1 3 4 2 2
    int left = 1, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        //计算从1到mid的值有几个
        if (nums[i] <= mid) {
          count++;
        }
      }
      if (count > mid) {
        //说明重复数字在[left,mid]之间
        right = mid;

      } else {
        //说明重复数字在 mid+1,right 之间
        left = mid + 1;

      }
    }
    return left;
  }

  public static void main(String args[]) {
    int array[] = {1, 3, 4, 2, 2};
    findDuplicate(array);
  }
}
