package com.jep.github.algorithm;

import com.jep.github.swordForOffer.Util;
import java.util.ArrayDeque;
import java.util.Arrays;

public class HeapSort {


  /**
   * @param array 数组
   * @param length 数组长度
   * @param index 元素位置
   */
  public static void heapify(int[] array, int length, int index) {
    if (index >= length) {
      return;
    }
    int c1 = 2 * index + 1;
    int c2 = 2 * index + 2;
    int maxIndex = index;
    if (c1 < length && array[c1] > array[maxIndex]) {
      maxIndex = c1;
    }
    if (c2 < length && array[c2] > array[maxIndex]) {
      maxIndex = c2;
    }

    if (maxIndex != index) {
      Util.swap(array, maxIndex, index);
      heapify(array, length, maxIndex);
    }
//    System.out.println(Arrays.toString(array));
  }


  public static void buildMaxHeap(int[] array) {
    int start = (array.length - 1) / 2;
    for (int i = start; i >= 0; i--) {
      System.out.println(i);
      heapify(array, array.length, i);
    }
  }

  public static void sort(int[] array) {
    buildMaxHeap(array);//堆构造
    int index = array.length - 1;
    while (index >= 0) {
      Util.swap(array, 0, index);
      heapify(array, index--, 0);
    }

  }


  public static void main(String[] args) {
    int[] arr = {20, 50, 20, 40, 70, 10, 80, 30, 60};
//    heapify(arr, 9, 0);
//    System.out.println(Arrays.toString(arr));//[50, 70, 20, 40, 20, 10, 80, 30, 60]
    sort(arr);
    System.out.println(Arrays.toString(arr));//[80, 70, 20, 60, 50, 10, 20, 30, 40]
  }
}