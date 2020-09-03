package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2020-09-02 8:28 AM
 */
public class _45_MinNumber {

  public static String minNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    String[] array = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      array[i] = String.valueOf(nums[i]);
    }
    quickSort(array, 0, nums.length - 1);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      stringBuilder.append(array[i]);
    }
    return stringBuilder.toString();
  }

  public static void quickSort(String[] array, int start, int end) {
    if (start >= end) {
      return;
    }

    int left = start;
    int right = end;
    String pivot = array[start];
    while (left < right) {
      // 从右往左找第一个小于基数的数
      while (left < right
          && (array[left] + array[right]).compareTo(array[right] + array[left]) <= 0) {
        right--;
      }

      // 从左往右找第一个大于基数的数
      while (left < right
          && (array[left] + array[right]).compareTo(array[right] + array[left]) > 0) {
        left++;
      }
      //找到这个数据后，指针停止移动，然后交换位置
      if (left < right) {
        swap(array, left, right);
      }

    }
    //两个指针会重叠，此时还要将pivot的索引和重叠位置交换
    swap(array, left, start);

    quickSort(array, start, left);
    quickSort(array, left + 1, end);
  }

  public static void swap(String[] array, int a, int b) {
    String tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

  public static void main(String args[]) {
//    3033459   1123
    int[] array = {1, 2, 3, 1};
    System.out.println(minNumber(array));

  }

}
