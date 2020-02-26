package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/**
 * @author jiangenping
 * 2020/2/26 下午8:44
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */

public class _189_RotateArray {

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        //1, 2, 3, 4, 5, 6, 7  ->  5,6,7, 1,2,3,4
        k = k % nums.length;
        //结果的前三位恰好是翻转后的前三位

        //1、 翻转整体
        reverse(nums, 0, nums.length - 1); //7,6,5,4,3,2,1
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);


    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums,2);
        Util.printArray(nums);

    }
}
