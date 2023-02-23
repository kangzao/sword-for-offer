package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

/*
 * @author: enping.jep
 * @create: 2020-07-01 3:30 PM
 *
 * nums1 = [1,2,3,0,0,0], m = 3
   nums2 = [2,5,6],       n = 3

   输出: [1,2,2,3,5,6]
 */
public class _88_Merge {

  public static void merge(int[] A, int m, int[] B, int n) {
    int p1 = m - 1, p2 = n - 1, p = m + n - 1;
    while (p1 >= 0 && p2 >= 0) {
      if (A[p1] > B[p2]) {
        A[p--] = A[p1--];
      } else {
        A[p--] = B[p2--];
      }
    }
    //p1可能先变成0，而p2可能还没有变为0,此时，直接将p2放在数组的前面即可
    while (p2 >= 0) {
      A[p--] = B[p2--];
    }


  }

  public static void main(String args[]) {
    int[] nums5 = {1, 2, 3, 0, 0, 0}, nums6 = {2, 5, 6};

//        mergeSortedArray(nums1, 3, nums2, 4);
//        Util.printArray(nums1);
////        Util.printArray(nums2);
//        mergeSortedArray(nums3, 0, nums4, 1);
//        Util.printArray(nums3);
    merge(nums5, 3, nums6, 3);

    Util.printArray(nums5);
    merge(nums5, 3, nums6, 3);
  }

}
