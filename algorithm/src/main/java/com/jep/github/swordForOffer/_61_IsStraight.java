package com.jep.github.swordForOffer;

import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2021-06-30 11:24 上午
 */
public class _61_IsStraight {

  public boolean isStraight(int[] nums) {
    Arrays.sort(nums);
    int joker = 0;
    for (int i = 0; i < 4; i++) {
      if (nums[i] == 0) {
        joker++;
      } else if (nums[i] == nums[i + 1]) {
        return false;
      }
    }
    //最大值减去最小值小于5，则说明是连续的
    return nums[4] - nums[joker] < 5;

  }
}
