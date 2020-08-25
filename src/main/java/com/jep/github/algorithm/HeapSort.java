package com.jep.github.algorithm;

import com.jep.github.swordForOffer.Util;

import java.util.ArrayDeque;
import java.util.Arrays;

public class HeapSort {

    /**
     * @param array  数组
     * @param length 数组长度
     * @param index  元素位置
     *               从顶部向下堆化(前提是，左右子树都已经是堆了)
     */
    public static void heapify(int[] array, int length, int index) {
        if (index >= length) {
            return;
        }
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int maxIndex = index;
        if (left < length && array[left] > array[maxIndex]) {
            maxIndex = left;
        }
        if (right < length && array[right] > array[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            Util.swap(array, maxIndex, index);
            heapify(array, length, maxIndex);
        }
    }

    public static void buildHeap(int[] array, int n) {
        int lastNode = n - 1;
        //parent = (i - 1)/2
        int parent = (lastNode - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            //非叶子节点分别进行heapify
            heapify(array, n, i);
        }
    }


    public static void sort(int[] array, int n) {
        buildHeap(array, n);
        for (int i = n - 1; i >= 0; i--) {
            Util.swap(array, i, 0);
            //i代表当前节点的数量
            heapify(array, i, 0);
        }

    }

    public static void main(String[] args) {
        int[] arr = {20, 50, 20, 40, 70, 10, 80, 30, 60};
        heapify(arr, 9, 0);
        System.out.println(Arrays.toString(arr));//[50, 70, 20, 40, 20, 10, 80, 30, 60]
        sort(arr, 9);
        System.out.println(Arrays.toString(arr));//[80, 70, 20, 60, 50, 10, 20, 30, 40]
    }
}