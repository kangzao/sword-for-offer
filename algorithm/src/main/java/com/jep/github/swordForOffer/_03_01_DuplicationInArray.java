package com.jep.github.swordForOffer;

/**
 * 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 注意：如果某些数字不在 0∼n−1 的范围内，或数组中不包含重复数字，则返回 -1；
 * <p>
 * 样例
 * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 * 返回 2 或 3。
 * <p>
 * author jiangenping
 * 2019/11/24 下午1:45
 *
 * https://wiki.jikexueyuan.com/project/for-offer/question-fifty-one.html
 */

public class _03_01_DuplicationInArray {

    /**
     * @param array
     * @return
     */
    public static int duplicationInArray(int[] array) {
        int length = array.length;
        // 判断输入的是否在[0, array.length-1]之间
        for (int i = 0; i < length; i++) {
            if (array[i] < 0 || array[i] >= length) {
                return -1;
            }
        }
        for (int i = 0; i < length; i++) {

            // 当number[i]与i不相同的时候一直交换
            while (array[i] != i) {
                // 如果i位置与number[i]位置的数字相同，说明有重复数字
                if (array[array[i]] == array[i]) {
                    return array[i];
                } else {
                    Util.swap(array, i, array[i]);
                }
                Util.printArray(array);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(duplicationInArray(numbers1));
//        int[] numbers2 = {2, 4, 3, 1, 4};
//        System.out.println(duplicationInArray(numbers2));
//        int[] numbers3 = {2, 4, 2, 1, 4};
//        System.out.println(duplicationInArray(numbers3));
//        int[] numbers4 = {2, 1, 3, 0, 4};
//        System.out.println(duplicationInArray(numbers4));
//        int[] numbers5 = {2, 1, 3, 5, 4};
//        System.out.println(duplicationInArray(numbers5));
    }
}
