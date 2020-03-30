package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;
import java.util.ArrayDeque;

/*
 * @author: enping.jep
 * @create: 2020-03-23 12:04 PM
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

    返回滑动窗口中的最大值。

    示例:

    输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    输出: [3,3,5,5,6,7]
    解释:

      滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

 */
public class _239_MaxSlidingWindow {

  //暴力法
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int max = Integer.MIN_VALUE;
    if (nums == null || nums.length == 0) {
      return null;
    }
    if (k > nums.length) {
      return null;
    }
    int length = nums.length - k + 1;
    int[] array = new int[length];
    for (int i = 0; i < length; i++) {
      for (int j = i; j < i + k; j++) {
        max = Math.max(max, nums[j]);
      }
      array[i] = max;
    }
    return array;
  }

//  public static int[] maxSlidingWindow_optimize(int[] nums, int k) {
//    int start = 0, end = 0;
//    int[] result = new int[nums.length - k + 1];//存放结果的数组
//    ArrayDeque<Integer> arrayDeque = new ArrayDeque();//单调递减队列
//    for (int i = 0; i < nums.length; i++) {
//      end++;
//      //确保队列单调递减
//      while (!arrayDeque.isEmpty() && nums[i] > arrayDeque.peekLast()) {
//        arrayDeque.pollLast();
//      }
//      arrayDeque.offerLast(i);
//      //判断队列中第一个元素是否在滑动窗口之外了
//      if(){
//
//      }
//
//    }
//
//  }


  public static void main(String args[]) {
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = maxSlidingWindow(array, 3);
    Util.printArray(result);
  }
}
