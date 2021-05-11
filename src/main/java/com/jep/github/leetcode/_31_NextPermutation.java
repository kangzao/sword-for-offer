package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-05-07 9:10 上午
 */
public class _31_NextPermutation {


  public void nextPermutation(int[] nums) {
    //1,2,3,8,5,7,6,4
    //“下一个排列”的定义是：给定数字序列的字典序中下一个更大的排列。如果不存在下一个更大的排列，
    // 则将数字重新排列成最小的排列（即升序排列）。
    //以123456为例，可以看到有这样的关系：123456 < 123465 < 123546 < ... < 654321
    //查找规律：如果数字中有一部分全都是降序 XXXX654，则654部分已经是最大字典顺序了，不存在更大的排列
    //先找非递减的那个数字，然后在递减区间再去找第一个大于该数字的较大值，因为这个较大值将用于后面和该数字交换，
    //所以必须大于该数字，否则交换后得到的结果并不会大于原来结果，此规律可得452631的较大值应该是453621
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    //找到第一个非降序点
    if (i >= 0) {
      //此时i之后的都是降序，1,2,3,8,5,7,6,4   i=4
      int j = nums.length - 1;
      //i之后的数字全部是升序，因此从右往左找到的第一个比nums[i]大的数组和nums[i]交换
      while (nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);//交换位置
    }
    //如果交换完了，后面的数字必须降序排列，才能刚好获得下一个更大的序列
    int k = nums.length - 1;
    i++;
    while (i < k) {
      swap(nums, i, k);
      i++;
      k--;
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
