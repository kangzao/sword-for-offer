package com.jep.github.leetcode;

import static com.jep.github.swordForOffer.Util.swap;

import com.jep.github.swordForOffer.Util;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/*
 * @author: enping.jep
 * @create: 2020-07-10 9:48 AM
 */
public class _215_FindKthLargest {

  private static Random random = new Random();

  public static int findKthLargest_heap(int[] nums, int k) {
    PriorityQueue<Integer> pqNums = new PriorityQueue<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      pqNums.offer(nums[i]);
      if (pqNums.size() > k) {
        //最小堆，把堆顶小于第k大元素的数字移除
        pqNums.poll();
      }
    }
    return pqNums.peek();
  }


  public static int findKthLargest(int[] nums, int k) {
    int len = nums.length;
    int target = len - k;
    int left = 0;
    int right = len - 1;
    while (true) {
      int index = randomPartition(nums, left, right);
      if (index < target) {
        left = index + 1;
      } else if (index > target) {
        right = index - 1;
      } else {
        return nums[index];
      }
    }
  }


  public static int randomPartition(int[] nums, int left, int right) {
    int i = random.nextInt(right - left + 1) + left;
    swap(nums, i, left);
    return partition(nums, left, right);
  }

  /**
   * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置 在遍历过程中保持循环不变量的语义 1、[left +
   * 1, j] < nums[left] 2、(j, i] >= nums[left]
   */
  public static int partition(int[] nums, int left, int right) {

    // 在区间随机选择一个元素作为标定点
    if (right > left) {
      int randomIndex = left + 1 + random.nextInt(right - left);
      swap(nums, left, randomIndex);
    }

    int pivot = nums[left];
    int j = left;
    for (int i = left + 1; i <= right; i++) {
      if (nums[i] < pivot) {
        j++;
        swap(nums, j, i);
      }
    }
    swap(nums, left, j);
    return j;
  }


  public static void main(String args[]) {

    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
    System.out.println(findKthLargest_heap(nums, k));
//    System.out.println(select(nums, 4));

  }
}
