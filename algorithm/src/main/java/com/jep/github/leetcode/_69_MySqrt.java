package com.jep.github.leetcode;

/**
 * author jiangenping 2020/7/28 下午9:06
 */

public class _69_MySqrt {

  public static int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }
    //x平方根的整数部分一定是小于x的，k² <= x,我们要求的就是这个整数部分
    int left = 1, right = x, ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid > x / mid) {
        right = mid - 1;
      } else {
        ans = mid;
        left = mid + 1;
      }
    }
    return ans;
  }


  public static void main(String[] args) {
    System.out.println(mySqrt(3));
  }
}
