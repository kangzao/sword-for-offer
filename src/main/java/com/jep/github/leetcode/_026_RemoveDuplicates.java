package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/**
 * author jiangenping
 * 2020/2/25 下午9:21
 * <p>
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class _026_RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;//慢指针
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
            }
            nums[slow] = nums[fast];
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 3, 4};
        System.out.println(removeDuplicates(array));
        Util.printArray(array);
    }
}
