package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-27 11:10 上午
 */
public class _213_Rob {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 1, nums.length - 1), robHelper(nums, 0, nums.length - 2));

    }

    //
    private int robHelper(int[] nums, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }


    public static void main(String args[]) {

    }

}
