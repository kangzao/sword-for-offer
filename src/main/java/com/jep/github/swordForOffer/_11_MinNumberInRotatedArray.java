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

  public static int minNumberInRotateArray(int[] numbers) {
    if (numbers.length == 0) {
      return 0;
    }
    int start = 0, end = numbers.length - 1;
    while (start < end) {
      //比如：93456
      int pivot = start + (end - start) / 2;
      if (numbers[pivot] < numbers[end]) {
        //说明pivot右侧递增 45123 mid的位置有可能指向最小值
        end = pivot;
      } else if (numbers[pivot] > numbers[end]) {
        //56934 mid的位置在最小值的左侧
        start = pivot + 1;
      } else {
        //45222 如果相等就用暴力法，移动右侧边界 其他情况可以二分
        //时间复杂度：log2n 所有数字相同是O(n)
        end--;
      }
    }
    return numbers[start];
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
