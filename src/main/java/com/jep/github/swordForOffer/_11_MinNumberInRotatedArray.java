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

  public static int minNumberInRotatedArray(int[] array) {
    int start = 0;
    int end = array.length - 1;
    while (start < end) { //这里不能<=，否则会数组越界 因为start=mid+1

      if (array[end] > array[start]) {
        return array[start];
      }
      //
      int mid = (end - start) / 2 + start;
      if (array[mid] >= array[start]) {
        //最小值出现在mid右侧
        start = mid + 1;  //这里+1去掉会死循环 while无法退出
      } else {
        //最小值出现在左半边 同时mid不能丢弃
        end = mid; //这里不能-1
      }
      System.out.println("start=" + start + ",end=" + end + "，mid=" + mid);
    }
    return array[start];
  }


  public static void main(String args[]) {
    int[] array = {3, 3, 5, 2, 2};
    System.out.println(minNumberInRotatedArray(array));
    int[] array1 = {2, 2, 2, 0, 1};
    System.out.println(minNumberInRotatedArray(array1));

    int[] array2 = {2, 0, 0, 2};
    System.out.println(minNumberInRotatedArray(array2));
  }

}
