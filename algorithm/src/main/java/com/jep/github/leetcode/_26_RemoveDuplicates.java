package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-21 10:03 上午
 */
public class _26_RemoveDuplicates {


  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    //slow指向被返回数组尾部，fast去检测有没有不同的数字，第0个位置不需要检测
    int slow = 1, fast = 1;
    while (fast < n) {
      //两个数字不相邻，将不同的数字放到数组的头部
      if (nums[fast - 1] != nums[fast]) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }

  public static void main(String args[]) {
    int[] nums = {1, 1, 2};
    _26_RemoveDuplicates rd = new _26_RemoveDuplicates();
    rd.removeDuplicates(nums);

  }

}
