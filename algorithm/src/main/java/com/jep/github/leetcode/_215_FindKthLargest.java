package com.jep.github.leetcode;

import java.util.Random;

/*
 * @author: enping.jep
 * @create: 2020-07-10 9:48 AM
 */
public class _215_FindKthLargest {

  Random random = new Random();


  public int findKthLargest(int[] nums, int k) {
    //nums.length - k 第k大的元素索引
    return quickSort(nums, 0, nums.length - 1, nums.length - k);
  }

  //
  private int quickSort(int[] a, int left, int right, int index) {
    int q = randomPartitiom(a, left, right);
    if (q == index) {
      return a[q];

    } else {
      return q < index ? quickSort(a, q + 1, right, index) : quickSort(a, left, q - 1, index);
    }
  }

  private int randomPartitiom(int[] a, int left, int right) {
    // 1. 随机数范围: [0, r-l+1) 同时加l, 则是 [l, r+1) = [l, r] 也就是在这个[l,r] 中随机选一个索引出来
    int i = random.nextInt(right - left + 1) + left;
    // 2. 交换nums[i]， nums[r], 也就是将随机数先放在[l,r]最右边nums[r]上
    swap(a, i, right);
    return partition(a, left, right);
  }

  // 本质是构建这样一种序列：[小 小 小 i 大 大 大 j 待比较 待比较 待比较 基准]
  private int partition(int[] a, int left, int right) {
    int x = a[right];
    int i = left - 1;
    // 这个for循环操作就是将小于 x 的数都往[i, j]的左边区间设置，从而实现存在[l, i]区间,使得对应数值都 小于 x
    for (int j = left; j < right; j++) {
      if (a[j] < x) {
        swap(a, ++i, j);
      }
    }
    swap(a, i + 1, right);
    return i + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }


  public static void main(String args[]) {

    int[] nums = {2, 1, 5, 0, 4, 6, 3};
    int k = 4;
//    System.out.println(findKthLargest_heap(nums, k));
//    System.out.println(select(nums, 4));
//    partition(nums, 0, nums.length - 1);

  }
}
