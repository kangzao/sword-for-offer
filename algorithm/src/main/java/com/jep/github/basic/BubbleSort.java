package com.jep.github.basic;

import com.jep.github.swordForOffer.Util;
import java.util.Arrays;

/*
   冒泡
 * @author: enping.jep
 * @create: 2020-07-10 8:57 AM
 */
public class BubbleSort {

  /**
   * 如何冒泡？也就是说，把数组中最小的那个往上冒，冒的过程就是和他相邻的元素交换。这个冒的过程就是内循环。
   *
   * 经过了一个冒的过程，可以使一个最小的元素冒出来，如果数组里面有 n 个元素，就得冒 n-1 次，这就是外循环。
   *
   *
   *
   * 假设有数组 array = {10,9,8,7,6,5,4,3,2,1}
   *
   *
   *
   * 则数组长度length = 10   外层循环需要循环10 - 1 = 9次     i = 0, 所以循环条件为 i < length - 1
   *
   *
   *
   * 内层循环相邻的两个元素比较，即j 和j+1进行比较，符合条件就交换，j+1<length,所以j<length - 1;由于外循环每循环一次，就有
   *
   *
   *
   * 一个最值出来(可以是最大值也可以是最小值)，这个最值可以排除出去，所以内层循环条件为 j<length - 1 -i
   **/
  private static void sort(int array[]) {
    for (int i = 0; i < array.length - 1; i++) {
      //由于外循环每循环一次，就有一个最值出来(可以是最大值也可以是最小值)，这个最值可以排除出去，所以内层循环条件为 j<length - 1 -i
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j + 1] < array[j]) {
          Util.swap(array, j, j + 1);
        }
      }
      Util.printArray(array);
    }
  }

  public static void main(String[] args) {
    int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
    sort(array);
    System.out.println(Arrays.toString(array));
  }

}
