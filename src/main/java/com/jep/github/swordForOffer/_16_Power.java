package com.jep.github.swordForOffer;


/**
 * author jiangenping
 * 2019/12/7 上午9:03
 */
// 16：数值的整数次方
// 题目：实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
public class _16_Power {


    public static double power(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            return 0;
        }
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        //负数的标志位
        double minus = 1;
        if (exponent < 0) {
            minus = -1;
            exponent = -exponent;
        }
        double result = 1;
        while (exponent-- != 0) {
            result = base * result;
        }
        if (minus < 0) {
            result = 1 / result;
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(power(2, 3) + ":8");
        System.out.println(power(-2, 3) + ":-8");
        System.out.println(power(2, -3) + ":0.125");
        System.out.println(power(2, 0) + ":1");
        System.out.println(power(0, 0) + ":0");
        System.out.println(power(0, 4) + ":0");
        System.out.println(power(0, -4) + ":infinity");
    }
}
