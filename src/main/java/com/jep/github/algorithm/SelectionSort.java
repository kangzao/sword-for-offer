package com.jep.github.algorithm;

import com.jep.github.swordForOffer.Util;

/**
 * author jiangenping
 * 2020/8/25 下午7:38
 * 选择排序
 * <p>
 * 1. 从待排序序列中，找到关键字最小的元素；
 * 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
 * 3. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */

public class SelectionSort {
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                Util.swap(array, min, i);
            }
        }


    }

    public static void main(String args[]) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        selectionSort(arr);
        Util.printArray(arr);

    }

}
