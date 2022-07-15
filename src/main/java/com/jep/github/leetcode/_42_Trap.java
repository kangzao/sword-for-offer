package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-05-11 3:01 下午
 */
public class _42_Trap {

  public int trap(int[] height) {
    int leftMax = 0, rightMax = 0;//左侧最大值和右侧最大值
    int left = 0, right = height.length - 1;//双指针，从左右两侧往中间移动
    int res = 0;
    while (left <= right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      //如果左边的最大值比右侧小，左侧可信，盛水量为较小的左侧最大值减去当前值
      if (leftMax <= rightMax) {
        res += leftMax - height[left];
        left++;
      } else {
        res += rightMax - height[right];
        right--;
      }
    }
    return res;
  }

}
