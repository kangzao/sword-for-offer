package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-22 10:24 上午
 */
public class _189_Rotate {

  public void rotate(int[] nums, int k) {
    k %= nums.length;
    int end = nums.length - 1;
    //先全部反转，然后数组分成两部分，前k个一组，后面的一组，分别反转
    reverse(nums, 0, end);
    reverse(nums, 0, k - 1);
    reverse(nums, k, end);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

}
