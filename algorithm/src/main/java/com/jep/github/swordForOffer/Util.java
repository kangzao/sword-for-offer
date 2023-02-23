package com.jep.github.swordForOffer;

/**
 * author jiangenping
 * 2019/11/24 下午2:50
 */

public class Util {
    /**
     * 交换数组中指定位置的两个元素
     *
     * @param array
     * @param a
     * @param b
     */
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * @param array
     */
    public static void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : array) {
            stringBuilder.append(n).append(",");
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1).toString());
    }

    public static void main(String[] args){
        int[] numbers = {2, 1, 3, 1, 4};
        printArray(numbers);
    }
}
