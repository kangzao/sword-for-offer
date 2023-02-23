package com.jep.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2021-07-27 3:28 下午
 */
public class _560_SubarraySum {

  public int subarraySum(int[] nums, int k) {
    /**
     用数组 prefixSum 表示，prefixSum[x]：第 0 项到 第 x 项 的和。
     prefixSum[x] = nums[0] + nums[1] + … +nums[x]
     nums 的某项 :nums[x] = prefixSum[x] - prefixSum[x - 1](两个相邻前缀和的差)
     nums 的 第 i 到 j 项 的和,nums[i]+ … +nums[j] = prefixSum[j] − prefixSum[i−1]

     当 i 为 0，此时 i-1 为 -1，我们故意让 prefixSum[-1] 为 0，使得通式在i=0时也成立：
     nums[0] +…+nums[j]=prefixSum[j]

     遍历 nums 之前，我们让 -1 情况下的前缀和为 0，这样通式在边界情况也成立。即在遍历之前，map 初始放入 0:1 键值对。


     */
    int preSum = 0;
    int count = 0;

    //map中的key表示前缀和为XX出现的次数
    Map<Integer, Integer> map = new HashMap<>();

    //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
    //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
    //输入：[3,1,1,0] k = 2时则不会漏掉
    //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
    map.put(0, 1);
    //遍历 nums 数组，求每一项的前缀和，统计对应的出现次数，键值对方式存入 map
    for (int i = 0; i < nums.length; i++) {
      preSum += nums[i];
      if (map.containsKey(preSum - k)) {
        count += map.get(preSum - k);
      }
      //  更新
      map.put(preSum, map.getOrDefault(preSum, 0) + 1);
    }
    return count;
  }

  public static void main(String args[]) {
    int[] array = {1, 1, 1};
    int k = 2;
    _560_SubarraySum subarraySumIns = new _560_SubarraySum();
    subarraySumIns.subarraySum(array, k);
  }

}
