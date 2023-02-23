package com.jep.github.leetcode;

import com.jep.github.swordForOffer.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author jiangenping
 * 2020/7/18 下午8:50
 */

public class _347_TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        //如果所有元素都相同，桶的编号就是nums.length + 1
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }


        for (Integer key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (null == bucket[frequency]) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int n = bucket.length - 1; n >= 0 && result.size() < k; n--) {
            if (bucket[n] != null) {
                result.addAll(bucket[n]);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 2;
        Util.printArray(topKFrequent(nums, k));

    }

}
