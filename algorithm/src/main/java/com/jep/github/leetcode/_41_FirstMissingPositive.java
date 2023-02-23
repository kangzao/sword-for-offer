package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-05-26 10:11 上午
 */
public class _41_FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    // 数字的范围是在1到N+1之间（闭区间），比如：1，2，3，4缺失的最小正整数是5
    // 3，4，-1，2缺失的最小正整数是1
    // 我们要找的数就在 [1, N + 1] 里，最后 N + 1 这个元素我们不用找。因为在前面的 N 个元素都找不到的情况下，我们才返回 N + 1；
    for (int i = 0; i < nums.length; i++) {
      //将数组看做hash表，第i个位置存放i+1这个数字,得到类似下面的结构，然后循环找到nums[i] != i + 1
      /**
       nums  0 1 2 3 4
       value 1 2 2 4 5
       */
      //nums[nums[i] - 1] != nums[i] 需要重点理解，nums[nums[i] - 1]表示nums[i]本应在的位置上的值是多少，即：存在重复值占位
      //如果nums[i]位置上的值就是nums[i]则没有必要调整了

      /**
       * 为什么使用 while ？ 因为交换后，原本 i 位置的 nums[i] 已经交换到了别的地方，
       *         交换后到这里的新值不一定是适合这个位置的，因此需要重新进行判断交换
       *         如果使用 if，那么进行一次交换后，i 就会 +1 进入下一个循环，那么交换过来的新值就没有去找到它该有的位置
       *          比如 nums = [3, 4, -1, 1] 当 3 进行交换后， nums 变成 [-1，4，3，1]，
       *          此时 i == 0，如果使用 if ，那么会进入下一个循环， 这个 -1 就没有进行处理
       */
      while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1
          && nums[nums[i] - 1] != nums[i]) {
        swap(nums, nums[i] - 1, i);
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  public void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

}
