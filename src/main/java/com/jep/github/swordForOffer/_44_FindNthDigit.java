package com.jep.github.swordForOffer;

/**
 * @author jiangenping
 * @date 2020/9/15 下午8:45
 */
public class _44_FindNthDigit {


    public int findNthDigit(int n) {

        long index = n;
        //已经遍历的数量
        long count = 0;
        long base = 1;
        //先求出占位的区间  如果在1-9  count数量是9*1  1-99 count的数量是9+9*10 1-999  count的数量是9+9*10+9*100
        while (count + base * 9 < index) {
            count += base * 9;
            base *= 10;
        }
        //根据count的值

    }

    public static void main(String[] args) {

    }
}
