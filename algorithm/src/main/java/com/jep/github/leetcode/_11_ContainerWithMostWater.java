package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create 2020-02-12 1:09 PM
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class _11_ContainerWithMostWater {

  public static int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    //索引位置
    int left = 0;
    int right = height.length - 1;
    int result = 0;
    //移动索引位置，找出最大面积
    while (left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      //左侧更小，则将左侧向内移动，间距变小（底部宽度减一），但高度很可能变大,则面积可能增大。如果向内移动长版，则水槽面积会更小（水槽短板不变或者变小）
      if (height[left] < height[right]) {
        left++;
      } else {
        //右侧更小或者相等，右侧向内移动
        right--;
      }
      if (area > result) {
        result = area;
      }
    }
    return result;
  }

  public static void main(String args[]) {
    System.out.println(maxArea(new int[]{1, 2, 4, 3})); // 4
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));// 49
  }


}
