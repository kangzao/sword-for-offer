package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;
import java.util.LinkedList;

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

     https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/

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


  public static int[] maxSlidingWindow_optimize(int[] nums, int k) {
    //头部存放最大值的索引，索引对应的值单调递减
    LinkedList<Integer> linkedList = new LinkedList<>();
    int[] result = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      //判断头部是否有效,如果无效，就把头部移除  当队首元素在原数组中的下标小于窗口左边界时，队首元素就需要移除队列。
      if (!linkedList.isEmpty() && linkedList.peek() <= i - k) {
        linkedList.poll();
      }
      //为了确保单调递减，如果数组中的元素大于队列尾部元素，则将尾部元素做出队处理(最大值肯定不在这些元素中，移除)，然后将新元素入队
      while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]) {
        linkedList.pollLast();
      }
      linkedList.addLast(i);
      //判断循环是否已经到达滑动窗口的边界，记录最大值
      if (i + 1 >= k) {
        result[i + 1 - k] = nums[linkedList.peek()];
      }
    }
    return result;
  }


  public static void main(String args[]) {
    int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
    int[] result = maxSlidingWindow(array, 3);
    Util.printArray(result);
    Util.printArray(maxSlidingWindow_optimize(array, 3));
  }
}
