package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-05-25 10:45 上午
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
   输出：[[1,6],[8,10],[15,18]]
   解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class _56_Merge {

  public static void main(String args[]) {
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    _56_Merge mergeInstance = new _56_Merge();
    mergeInstance.merge(intervals);


  }


  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return new int[0][2];
    }
    //按照左侧区间排序
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] intervals1, int[] intervals2) {
        return intervals1[0] - intervals2[0];
      }
    });
    //定义结果数组
    List<int[]> merged = new ArrayList<>();
    //将二维数组的第一个值加入到结果中
    //后续添加元素时，如果新元素的左边界大于merged中的最后一个元素的右边界，说明没有重合，则直接加入到结果集
    for (int i = 0; i < intervals.length; i++) {
      int L = intervals[i][0], R = intervals[i][1];
      if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
        merged.add(new int[]{L, R});
      } else {
        //如果有重合，则更新merged中最后一个元素最右侧的值
        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
      }
    }
    return merged.toArray(new int[merged.size()][]);

  }
}


