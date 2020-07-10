package com.jep.github.algorithm;

import com.jep.github.swordForOffer.Util;
import java.util.Arrays;

/*
   冒泡
 * @author: enping.jep
 * @create: 2020-07-10 8:57 AM
 */
public class BubbleSort {

  private static void sort(int array[]) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j + 1] < array[j]) {
          Util.swap(array, j, j + 1);
        }
      }
    }

  }

  public static void main(String[] args) {
    int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
    sort(array);
    System.out.println(Arrays.toString(array));
  }

}
