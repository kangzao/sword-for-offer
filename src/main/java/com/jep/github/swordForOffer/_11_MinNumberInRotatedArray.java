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

  public static int minNumberInRotateArray(int[] rotateArray) {
    if (rotateArray.length == 0) {
      return 0;
    }

    int low = 0;
    int high = rotateArray.length - 1;
    int mid = 0;

    while (low < high) {
      // 子数组是非递减的数组，10111
      if (rotateArray[low] < rotateArray[high]) {
        return rotateArray[low];
      }
      mid = low + (high - low) / 2;
      if (rotateArray[mid] > rotateArray[low]) {
        low = mid + 1;
      } else if (rotateArray[mid] < rotateArray[high]) {
        high = mid;
      } else {
        low++;
      }
    }
    return rotateArray[low];
  }


  public static void main(String args[]) {
    int[] array = {3, 3, 5, 2, 2};
    System.out.println(minNumberInRotateArray(array));
    int[] array1 = {2, 2, 2, 0, 1};
    System.out.println(minNumberInRotateArray(array1));

//        System.out.println(solution(array1));

    int[] array2 = {2, 0, 1, 2, 2, 2, 2};
    System.out.println(minNumberInRotateArray(array2));
  }

}
