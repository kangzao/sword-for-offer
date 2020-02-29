package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/**
 * author jiangenping
 * 2020/2/29 下午1:37
 */

public class _66_PlusOne {

    public static int[] plusOne(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            array[i]++;
            array[i] %= 10;
            if (array[i] != 0) {
                return array;
            }
        }
        array = new int[array.length + 1];
        array[0] = 1;
        return array;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
        int[] array1 = {9, 9, 9, 9};
        int[] array2 = {8, 9, 9, 9};
        Util.printArray(plusOne(array));
        Util.printArray(plusOne(array1));
        Util.printArray(plusOne(array2));

    }
}
