package com.jep.github.swordForOffer;

/**
 * author jiangenping
 * 2019/12/7 下午12:06
 */

// 17：打印1到最大的n位数
// 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
// 打印出1、2、3一直到最大的3位数即999。
// 核心问题是大数问题，牵涉到大数问题我们可以将其转化为字符串表示。
public class _17_Print1ToMaxOfNDigits {

    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
//        while (!overFlow(sb, n)) {
//
//        }
    }

    //加法如果溢出返回true
//    public static boolean overFlow(char[] numbers, int n) {
//        for (int i = numbers.length - 1; i >= 0; i--) {
//
//        }
//    }

    public void printNumber(StringBuilder stringBuilder, int n) {

    }

    public static void main(String[] args) {
        System.out.println('0');
        System.out.println(0 - '0');
    }
}
