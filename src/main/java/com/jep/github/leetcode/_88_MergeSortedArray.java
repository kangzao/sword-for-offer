package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/*
 * @author: enping.jep
 * @date: 2019/12/4
 * @create 2019-12-04 9:15 AM
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class _88_MergeSortedArray {

    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        //定义三个指针
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        //索引必须>=0
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
        //第二个数组还有剩余，则继续填充，第一个如果有剩余不用管，因为就是它本身
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }

    }

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0, 0, 0}, nums2 = {2, 5, 6, 7};
        int[] nums3 = {0}, nums4 = {1};
        int[] nums5 = {4, 5, 6, 0, 0, 0}, nums6 = {1, 2, 3};


        mergeSortedArray(nums1, 3, nums2, 4);
        Util.printArray(nums1);
//        Util.printArray(nums2);
        mergeSortedArray(nums3, 0, nums4, 1);
        Util.printArray(nums3);
        mergeSortedArray(nums5, 3, nums6, 3);
        Util.printArray(nums5);
    }

}