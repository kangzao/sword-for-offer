package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-08-28 2:47 PM
 * @update：2021年07月27日19:09:03
 */
public class _18_FourSum {


  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length;

    for (int i = 0; i < n - 3; i++) {
      //防止重复
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      //数组升序，如果已经大于target，直接退出
      if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
        break;
      }
      if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
        continue;
      }
      //确定了一个数字之后，则计算三数之和
      for (int j = i + 1; j < n - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
          break;
        }
        if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
          continue;
        }

        int left = j + 1, right = n - 1;
        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            //去重
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            left++;
            //去重
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }

            right--;
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return res;
  }

  public static void main(String args[]) {
//    int[] array = {1, 0, -1, 0, -2, 2};
//    System.out.println(fourSum(array, 0));

    int[] array1 = {0, 0, 0, 0, 0, 0};
    System.out.println(fourSum(array1, 0));

  }

}
