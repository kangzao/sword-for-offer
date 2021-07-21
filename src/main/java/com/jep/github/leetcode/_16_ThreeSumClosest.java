package com.jep.github.leetcode;

import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2021-07-21 1:41 下午
 */
public class _16_ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    //这里res不设置成Integer.MAX_VALUE，是因为Integer.MAX_VALUE减去负数会变成Integer.MIN_VALUE
    int res = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(sum - target) < Math.abs(res - target)) {
          res = sum;
          System.out.println(res);
        }
        if (sum > target) {
          right--;
        } else if (sum < target) {
          left++;
        } else {
          return sum;
        }
      }
    }
    return res;
  }

  public static void main(String args[]) {
    int array[] = {1, 2, 4, 8, 16, 32, 64, 128};
    int target = 82;
    _16_ThreeSumClosest instance = new _16_ThreeSumClosest();
    System.out.println(instance.threeSumClosest(array, target));

  }

}
