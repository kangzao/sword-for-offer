package com.jep.github.swordForOffer;

/**
 * 给定一个长度为 n+1 的数组nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
 * <p>
 * 请找出数组中任意一个重复的数，但不能修改输入的数组。
 * <p>
 * 样例
 * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 * <p>
 * 返回 2 或 3。
 * <p>
 * author jiangenping
 * 2019/11/24 下午6:18
 */

public class _03_02_DuplicationInArray {

    /**
     * 一共有 n+1 个数，每个数的取值范围是1到n，所以至少会有一个数出现两次。
     * 然后我们采用分治的思想，将每个数的取值的区间[1, n]划分成[1, n/2]和[n/2+1, n]两个子区间，然后分别统计两个区间中数的个数。
     * 注意这里的区间是指数的取值范围，而不是数组下标
     *
     * @param array
     * @return
     * https://my.oschina.net/firepation/blog/2239952
     */
    public static int duplicationInArray(int[] array) {
        int left = 1;//左边界
        int right = array.length - 1;//右边界
        while (left < right) {
            int middle = (right + left) >> 1;//将数组一分为二
            System.out.println("middle=" + middle);
            int count = 0; //左边元素的个数
            for (int element : array) {
                if (element >= left && element <= middle) {
                    count++;
                }
            }
            //判断是否大于左半边的区间长度,如果大于，则选左边，说明重复的数字出现在左半边，那么就将范围缩小到左半边
            if (count > middle - left + 1) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(duplicationInArray(nums));
    }

}
