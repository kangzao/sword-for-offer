package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-14 10:18 上午
 */
public class _136_SingleNumber {

  //数组中的全部元素的异或运算结果即为数组中只出现一次的数字
  public int singleNumber(int[] nums) {
    int single = 0;
    for (int i = 0; i < nums.length; i++) {
      single ^= nums[i];
    }
    return single;
  }

}
