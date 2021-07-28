package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/*
 * @author: enping.jep
 * @create: 2021-07-28 10:53 上午
 */
public class _75_SortColors {

  public void sortColors(int[] nums) {
    int n = nums.length;
    //p0指向0，p2指向2
    int p0 = 0, p2 = n - 1;
    for (int i = 0; i < n; i++) {
      //把2移动到数组尾部,当我们找到2时，需要不断地将其与nums[p2]交换，直到新的nums[i]不为2 否则 2，1，2这种情况交换
      //后顺序仍旧不变
      while (i < p2 && nums[i] == 2) {
        swap(nums, i, p2);
        p2--;
      }
      if (nums[i] == 0) {
        swap(nums, i, p0);
        p0++;
      }
    }
  }

  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String args[]) {
    int[] array = {2, 1, 2};
    _75_SortColors solution = new _75_SortColors();
    solution.sortColors(array);
    Util.printArray(array);
  }

}
