package com.jep.github.leetcode;

/**
 * author jiangenping
 * 2020/8/2 上午10:47
 */

public class _540_SingleNonDuplicate {


    public static int singleNonDuplicate(int[] nums) {
        //由于单个数组只会出现在奇数子数组范围内，奇数子数组的首尾index都是偶数，因此只需要遍历偶数索引
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--; //确保mid是偶数
            }
            //如果成立，则此前的数字一定是成对出现
            if (nums[mid] == nums[mid + 1]) {
                left += 2;
            } else {
                right = mid;//mid是偶数，说明0-mid是奇数子数组，单个数字一定出现在奇数子数组中，可以缩小范围
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {

//        [1,1,2,3,3,4,4,8,8]  2
//        [3,3,7,7,10,11,11]   10

    }
}
