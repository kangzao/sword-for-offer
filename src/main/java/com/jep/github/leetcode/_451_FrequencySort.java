package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2020-07-20 10:06 AM
 */
public class _451_FrequencySort {

  public static String frequencySort(String s) {

    Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
    for (Character c : s.toCharArray()) {
      frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }

    List<Character>[] bucket = new List[s.length() + 1];

    for (Character c : frequencyMap.keySet()) {
      int index = frequencyMap.get(c);

      if (bucket[index] == null) {
        bucket[index] = new ArrayList<Character>();
      }
      bucket[index].add(c);
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (int i = bucket.length - 1; i > 0; i--) {
      if (bucket[i] == null) {
        continue;
      }

      for (char c : bucket[i]) {
        for (int j = 0; j < i; j++) {
          stringBuilder.append(c);
        }
      }

    }
    return stringBuilder.toString();


  }

  public static void main(String args[]) {
    String str = "tree";
    System.out.println(frequencySort(str));
  }

}
