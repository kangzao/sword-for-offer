package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-05-11 3:01 下午
 */
public class _42_Trap {

  public int trap(int[] height) {
    int left_max = Integer.MIN_VALUE, right_max = Integer.MIN_VALUE;
    int res = 0;
    for (int left = 0, right = height.length - 1; left <= right; ) {
      left_max = Math.max(left_max, height[left]);
      right_max = Math.max(right_max, height[right]);
      //能否蓄水取决于左侧最大和右侧最大的关系，如果左侧较大，根据木桶原理，右侧的位置可以确定蓄水量
      //如果如果右侧较大，那左侧的位置可以确定蓄水量
      if (left_max < right_max) {
        //计算左侧的蓄水量
        res += left_max - height[left];
        left++;
      } else {
        res += right_max - height[right];
        right--;
      }
    }
    return res;
  }

}
