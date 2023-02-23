package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-05-07 9:10 上午
 */
public class _31_NextPermutation {


  public void nextPermutation(int[] nums) {
    //1 2 3 8 5 7 6 4
    //7 6 4是降序，是最大字典顺序，要找到降序点,从后向前找降序点
    int i = nums.length - 2;
    //i >=0 必须放在前面，否则，i会变成负数
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    // System.out.println(i);
    //此时i走到降序点，即 5 所在的位置 在降序点后找一个比5大的最小数和5交换 如果是 3,2,1 则 i会变成-1，跳过下面的if语句
    //
    if (i >= 0) {
      int j = nums.length - 1;
      //j如果不满足条件则继续移动
      while (j >= 0 && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    //1 2 3 8 6 7 5 4
    //将i之后的数字进行排序，从小到大排序，此时 7 5 4肯定是降序，直接反转数组即可
    reverse(nums, i);
  }

  public void reverse(int[] nums, int after) {
    int i = after + 1, j = nums.length - 1;
    while (i <= j) {
      swap(nums, i++, j--);
    }
  }

  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String args[]) {
    int[] array = {1, 2};
    _31_NextPermutation permutation = new _31_NextPermutation();
    permutation.nextPermutation(array);

  }


}
