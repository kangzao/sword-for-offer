package com.jep.github.algorithm;

import com.jep.github.swordForOffer.Util;

/**
 * 快速排序
 * author jiangenping
 * 2020/8/24 下午8:24
 * ①. i = L; j = R; 将基准数挖出形成第一个坑a[i]。
 * ②．j--，由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
 * ③．i++，由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
 * ④．再重复执行②，③二步，直到i==j，将基准数填入a[i]中
 */

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length <= 0 || low > high) {
            return;
        }

        int left = low;
        int right = high;
        int pivot = arr[left];

        while (left < right) {
            //右侧一直大于基准值，则右侧一直往左移动
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //右侧的值小于或者等于基准值，则将右侧数据移动到左侧
            arr[left] = arr[right];

            //左侧的值一直小于基准值，则左侧一直向右移动
            while (left < right && arr[left] < pivot) {
                left++;
            }
            //左侧的值大于或者等于基准值，则将左侧的数据移动到右侧
            arr[right] = arr[left];
            Util.printArray(arr);
            System.out.println("left=" + left + ",right=" + right + ",pivot=" + pivot);
        }

        arr[left] = pivot;
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);

    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 5, 0};
        quickSort(arr, 0, 5);
        Util.printArray(arr);

    }


}
