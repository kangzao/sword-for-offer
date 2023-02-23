package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-14 10:18 上午
 */
public class _136_SingleNumber {

  //数组中的全部元素的异或运算结果即为数组中只出现一次的数字

  /**
   * 异或解法：异或运算满足交换律，a^b^a=a^a^b=b,因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
   * 然后再根据交换律把相等的合并到一块儿进行异或（结果为0），然后再与只出现过一次的元素进行异或，
   * 这样最后的结果就是，只出现过一次的元素（0^任意值=任意值）
   * @param nums
   * @return
   */
  public int singleNumber(int[] nums) {
    int single = 0;
    for (int i = 0; i < nums.length; i++) {
      single ^= nums[i];
    }
    return single;
  }

}
