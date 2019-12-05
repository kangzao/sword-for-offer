package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/11/28
 * @create 2019-11-28 6:31 PM
 *
 */

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//
//    Find the minimum element.
//
//    You may assume no duplicate exists in the array.
//
//    Example 1:
//
//    Input: [3,4,5,1,2]
//    Output: 1
//    Example 2:
//
//    Input: [4,5,6,7,0,1,2]
//    Output: 0
//    对应leetcode 153
public class _11_MinNumberInRotatedArray {


    public static int solution(int[] nums) {
        int n = nums.length - 1;
        if (n < 0) return -1;
        while (n > 0 && nums[n] == nums[0]) n--;
        if (nums[n] >= nums[0]) return nums[0];
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;       // [l, mid], [mid + 1, r]
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
            System.out.println("L=" + l + ",R=" + r);
        }
        return nums[r];
    }

    public static int minNumberInRotatedArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (end > 0 && array[end] == array[0]) end--;
        if (array[end] >= array[start]) {
            return array[start];
        }

        while (start < end) {

            int mid = (end - start) / 2 + start;
//            System.out.println(mid);
            if (array[mid] < array[start]) {
                end = mid;
            } else {
                start = mid + 1;
            }
            System.out.println("start=" + start + ",end=" + end);

        }
        return array[end];
    }


    public static void main(String args[]) {
//        int[] array = {3, 3, 5, 2, 2};
//        System.out.println(minNumberInRotatedArray(array));
        int[] array1 = {2, 2, 2, 0, 1};
        System.out.println(minNumberInRotatedArray(array1));

        System.out.println(solution(array1));

        int[] array2 = {2, 0, 1, 2, 2, 2, 2};
        System.out.println(minNumberInRotatedArray(array2));
    }

}
