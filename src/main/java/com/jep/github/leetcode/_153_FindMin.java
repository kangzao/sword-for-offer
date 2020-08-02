package com.jep.github.leetcode;

/**
 * author jiangenping
 * 2020/8/2 下午1:17
 */

public class _153_FindMin {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right])
                return nums[left];
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else if (nums[right] > nums[mid]) {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};  // 4,5,6,7,0,1,2
        System.out.println(findMin(array));

    }
}
