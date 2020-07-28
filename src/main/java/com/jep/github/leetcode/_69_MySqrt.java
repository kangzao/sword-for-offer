package com.jep.github.leetcode;

/**
 * author jiangenping
 * 2020/7/28 下午9:06
 */

public class _69_MySqrt {

    public static int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
//            System.out.println(mid);
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
        //必须返回right，原因是left在最后一次循环会+1，会比预期结果大1
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
    }
}
