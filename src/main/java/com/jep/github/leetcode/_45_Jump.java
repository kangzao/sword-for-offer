package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-08-25 2:56 下午
 */
public class _45_Jump {

  public int jump(int[] nums) {
    //次数最少，尽量要做到每次跳跃都能到达最远
    int maxPositon = 0; // 最远的位置
    int end = 0; //边界
    int step = 0; //跳跃次数
    for (int i = 0; i < nums.length - 1; i++) {
      maxPositon = Math.max(maxPositon, i + nums[i]);
      if (end == i) {
        end = maxPositon;
        step++;
      }
    }
    return step;
  }

}
