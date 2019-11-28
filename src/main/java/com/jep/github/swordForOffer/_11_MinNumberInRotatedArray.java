package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/11/28
 * @create 2019-11-28 6:31 PM
 */

// 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个非递减数组的一个旋转，输出旋转数组的最小元素。例如数组
// {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
public class _11_MinNumberInRotatedArray {

  public static int minNumberInRotatedArray(int[] array) {
    int start = 0;
    int end = array.length - 1;

    while (start < end) {
      if (array[end] > array[start]) {
        return array[start];
      }
      int mid = (start + end) / 2;
      if (mid > start) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return array[start];
  }


  public static void main(String args[]) {
    int[] array = {3, 3, 5, 2, 2};
    System.out.println(minNumberInRotatedArray(array));
  }

}
