package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2021-04-22 6:26 下午
 */
public class _53_Search {

  public int search(int[] nums, int target) {
    // 5,7,8,8,8,10 找到7的右侧边界left(数字8),找到target的右侧边界right(数字10)
    //出现次数=right - left
    return right_bound(nums, target) - right_bound(nums, target - 1);

  }

  //求target的右侧边界,利用二分法
  public int getRight(int[] nums, int target) {
    int i = 0, j = nums.length - 1;
    while (i <= j) {
      int m = (i + j) / 2;
      if (nums[m] <= target) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }
    return i;
  }


  int right_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        // 别返回，锁定右侧边界
        left = mid + 1;
      }
    }
    return right;
  }


  public static void main(String args[]) {
    _53_Search search = new _53_Search();
    int[] nums = {5, 7, 8, 8, 8, 10};
    int target = 8;
    System.out.println(search.search(nums, target));
  }

}
