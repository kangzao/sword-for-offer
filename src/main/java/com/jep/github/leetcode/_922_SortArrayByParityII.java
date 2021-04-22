package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-22 3:08 下午
 */
public class _922_SortArrayByParityII {

  public int[] sortArrayByParityII(int[] nums) {
    int j = 1, n = nums.length;
    //i指向偶数位置,j指向奇数位置
    for (int i = 0; i < n; i += 2) {
      //i指向的数字是奇数，则需要交换
      if (nums[i] % 2 == 1) {
        while (nums[j] % 2 == 1) {
          j += 2;
        }
        swap(nums, i, j);
      }
    }
    return nums;
  }

  public void swap(int[] nums, int p, int q) {
    int tmp = 0;
    tmp = nums[p];
    nums[p] = nums[q];
    nums[q] = tmp;
  }

}
