package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-02-14 6:29 PM
 *
   给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
   注意：答案中不可以包含重复的三元组。
 */
public class _15_ThreeSum {


  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 3) {
      return res;
    }
    Arrays.sort(nums);//升序排序
    for (int i = 0; i < nums.length; i++) {
      //如果当前数字大于0，则三数之和一定大于0，退出
      if (nums[i] > 0) {
        break;
      }
      //去除重复
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        //恰好等于0的时候，要去重
        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left + 1] == nums[left]) {
            left++;
          }
          while (left < right && nums[right - 1] == nums[right]) {
            right--;
          }
          left++;
          right--;
        } else {
          if (sum < 0) {
            left++;
          }
          if (sum > 0) {
            right--;
          }
        }
      }
    }
    return res;
  }

  public static void main(String args[]) {
    int array[] = {-4, -1, -1, 0, 1, 2};
    System.out.println(threeSum(array));
  }


}
