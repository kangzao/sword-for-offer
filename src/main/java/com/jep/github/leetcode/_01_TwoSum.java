package com.jep.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2021-03-31 8:10 下午
 *
 * 输入：nums = [2,7,11,15], target = 9
   输出：[0,1]
   解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class _01_TwoSum {

  public int[] twoSum(int[] nums, int target) {
    if (nums.length == 0) {
      return null;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

}
