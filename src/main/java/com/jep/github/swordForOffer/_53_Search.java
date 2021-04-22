package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2021-04-22 6:26 下午
 */
public class _53_Search {

  public int search(int[] nums, int target) {
    // 5,7,8,8,8,10 找到7的右侧边界left(数字8),找到target的右侧边界right(数字10)
    //出现次数=right - left
    return getRight(nums, target) - getRight(nums, target - 1);

  }

  //求target的右侧边界,利用二分法
  public int getRight(int[] nums, int target) {
    int i = 0, j = nums.length - 1;
    while (i <= j) {
      int m = i + (j - i) / 2;
      if (nums[m] > target) {
        j--;
      } else {
        i++;
      }
    }
    return j;
  }

}
