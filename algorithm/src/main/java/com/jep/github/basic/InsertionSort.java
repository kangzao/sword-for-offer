package com.jep.github.basic;

import com.jep.github.swordForOffer.Util;


/**
 * author jiangenping
 * 2020/8/24 下午10:45
 * 1. 从第一个元素开始，该元素可以认为已经被排序
 * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * 5. 将新元素插入到该位置后
 * 6. 重复步骤2~5
 */
public class InsertionSort {

  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int tmp = array[i];
      for (int j = i; j >= 0; j--) {
        if (j - 1 >= 0 && array[j - 1] > tmp) {
          array[j] = array[j - 1];
        } else {
          array[j] = tmp;
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
    insertionSort(array);
    Util.printArray(array);
  }
}
