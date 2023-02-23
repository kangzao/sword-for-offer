package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/12/19
 * @create 2019-12-19 12:15 PM
 */
// 调整数组顺序使奇数位于偶数前面
// 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
// 奇数位于数组的前半部分，所有偶数位于数组的后半部分。

/**
 * 用两个指针分别从首尾开始，往中间扫描。扫描时保证第一个指针前面的数都是奇数，第二个指针后面的数都是偶数。
 * <p>
 * 每次迭代时需要进行的操作：
 * <p>
 * 第一个指针一直往后走，直到遇到第一个偶数为止； 第二个指针一直往前走，直到遇到第一个奇数为止； 交换两个指针指向的位置上的数，再进入下一层迭代，直到两个指针相遇为止；
 **/
public class _21_ReorderArray {


  public int[] exchange(int[] nums) {
    int head = 0;
    int tail = nums.length - 1;
    while (head < tail) {
      //如果是奇数就移动
      while (isOdd(nums[head]) && head < tail) {
        head++;
      }
      //如果是偶数就移动
      while (!isOdd(nums[tail]) && head < tail) {
        tail--;
      }
      swap(nums, head++, tail--);
    }
    return nums;

  }

  public boolean isOdd(int number) {
    return number % 2 == 1;
  }

  public void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }


  public static void reorderArray(int[] array) {
    if (array == null || array.length < 2) {
      return;
    }
    int left = 0, right = array.length - 1;
    while (left < right) {
      System.out.println(left + "--" + right);
      //如果left经过奇数，则left继续移动
      if (!isEven(array[left])) {
        left++;
      }
      //如果right经过偶数，则right继续移动
      if (isEven(array[right])) {
        right--;
      }
      if (isEven(array[left]) && !isEven(array[right])) {
        Util.swap(array, left, right);
        left++;
        right--;
      }
    }

  }

  // 是否是偶数
  public static boolean isEven(int number) {
    return number % 2 == 0;
  }


  public static void main(String args[]) {
//    int[] array = {1, 2, 3, 4, 5, 6, 7};
//    reorderArray(array);
//    Util.printArray(array);
//    int[] array1 = {1, 3, 5, 7, 9};
//    reorderArray(array1);
//    Util.printArray(array1);
//
//    int numbers[] = {2, 4, 6, 1, 3, 5, 7};
//    reorderArray(numbers);
//    Util.printArray(numbers);
//
//    int numbers1[] = {2, 9, 9, 5, 3, 2, 9, 6, 0, 4};
//    reorderArray(numbers1);
//    Util.printArray(numbers1);

    int[] array_1 = {1, 3, 5};
    _21_ReorderArray reorderArray = new _21_ReorderArray();
    reorderArray.exchange(array_1);

  }

}
