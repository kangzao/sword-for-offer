package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-07-23 10:15 AM
 */
public class _605_CanPlaceFlowers {

//  输入: flowerbed = [1,0,0,0,1], n = 1
//  输出: True
//
//  输入: flowerbed = [1,0,0,0,1], n = 2
//  输出: False

  public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    int length = flowerbed.length;
    int count = 0;
    for (int i = 0; i < length; i++) {
      if (flowerbed[i] == 1) {
        continue;
      }

      int pre = i == 0 ? flowerbed[0] : flowerbed[i - 1];
      int next = i == length - 1 ? 0 : flowerbed[i + 1];

      if (pre == 0 && next == 0) {
        count++;
        flowerbed[i] = 1;
      }
    }
    return count >= n;
  }


  public static void main(String args[]) {
    int[] array = {1, 0, 0, 0, 1};
    System.out.println(canPlaceFlowers(array, 1));
  }
}
