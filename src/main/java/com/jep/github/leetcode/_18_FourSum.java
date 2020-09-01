package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-08-28 2:47 PM
 */
public class _18_FourSum {


  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    int right = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
      int n1 = nums[i];
      //有序数组，第N位大于target则后面的不用判断
      if (n1 > 0 && n1 > target) {
        break;
      }
      //防止重复,当前数字和前一个数字相同则跳出当前循环
      if (i > 0 && nums[i - 1] == n1) {
        continue;
      }

      //三数之和
      for (int j = i + 1; j < nums.length; j++) {
        List<Integer> subList = new ArrayList<>();
        int n2 = nums[j];
        if (n2 > 0 && n2 + n1 > target) {
          break;
        }
        //这里容易写成j>1，那么0, 0, 0, 0, 0, 0和target=0会没有结果
        if (j > i + 1 && nums[j - 1] == nums[j]) {
          continue;
        }
        int left = j + 1;
        while (left < right) {
          int n3 = nums[left];
          int n4 = nums[right];
          int sum = n1 + n2 + n3 + n4;
          if (sum == target) {
            list.add(Arrays.asList(n1, n2, n3, n4));
            //当条件满足时，左右指针肯定要各自移动，但在移动过程中可能出现重复，比如：10202左右指针在0和2上，需要除重。
            while (left < right && nums[left] == n3) {
              left++;
            }
            while (left < right && nums[right] == n4) {
              right--;
            }
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
      }

    }
    return list;
  }

  public static void main(String args[]) {
//    int[] array = {1, 0, -1, 0, -2, 2};
//    System.out.println(fourSum(array, 0));

    int[] array1 = {0, 0, 0, 0, 0, 0};
    System.out.println(fourSum(array1, 0));

  }

}
