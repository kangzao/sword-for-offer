package com.jep.github.algorithm;

import com.jep.github.swordForOffer.Util;
import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2020-08-25 9:31 AM
 */
public class ShellSort {


  public static void shellSort(int[] arr) {
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < arr.length; i++) {
        int j = i;
        int tmp = arr[j];
        if (arr[j] < arr[j - gap]) {
          while (j - gap >= 0 && tmp < arr[j - gap]) {
            arr[j] = arr[j - gap];
            j -= gap;
          }
        }
        arr[j] = tmp;
      }
    }
  }


  public static void main(String args[]) {
//    int[] arr = {2, 1, 4, 6, 5, 0};
//    shellSort(arr);
    int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
    shellSort(arr1);
    Util.printArray(arr1);


  }

  /**
   * 希尔排序 针对有序序列在插入时采用移动法。
   */
  public static void sort1(int[] arr) {
    //增量gap，并逐步缩小增量
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {

      System.out.println(gap);
      //从第gap个元素，逐个对其所在组进行直接插入排序操作
      for (int i = gap; i < arr.length; i++) {
        int j = i;
        int temp = arr[j];
        if (arr[j] < arr[j - gap]) {
          while (j - gap >= 0 && temp < arr[j - gap]) {
            //移动法
            arr[j] = arr[j - gap];
            j -= gap;
//            Util.printArray(arr);
          }
          arr[j] = temp;
        }
      }
    }
  }


}
