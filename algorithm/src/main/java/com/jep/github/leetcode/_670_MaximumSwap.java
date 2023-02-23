package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-07-21 10:48 上午
 */
public class _670_MaximumSwap {

  // 将右侧最大值和左侧的值交换构成最大的数字
  public int maximumSwap(int num) {
    char[] array = String.valueOf(num).toCharArray();
    int[] order = new int[array.length];//从后先前记录访问过的最大值的索引
    int maxIndex = array.length - 1;
    // 从后往前遍历，避免1993交换后出现9193而不是9913
    /**
     举个例子98368，order = [0,4,4,4,4],chars[0] = chars[order[0]] = 9 跳过
     chars[1] = 8, chars[order[1]] = chars[4] = 8 相等 继续跳过
     chars[2] = 3, chars[order[3]] = chars[4] = 8 不相等，交换
     只要交换完成则跳出循环
     */
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] > array[maxIndex]) {
        maxIndex = i;
      }
      order[i] = maxIndex;
    }
    //将右边最大的数字放到最左侧
    for (int i = 0; i < array.length; i++) {
      if (array[i] != array[order[i]]) {
        swap(array, i, order[i]);
        break;
      }
    }
    return Integer.parseInt(new String(array));
  }

  public void swap(char[] array, int i, int j) {
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

}
