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


    public int[][] merge_new(int[][] intervals) {
        //先按照第一个元素排序，intervals中的元素变得相对有序，有三种关系，包含、相交、没有交集
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int len = intervals.length;
        int[][] array = new int[len][2];
        int lastIndex = -1;//指向结果数组最后一组元素
        for (int i = 0; i < len; i++) {
            //第一次需要直接加入到结果集，然后用当前值和结果中的进行比较[1,3] [4,8]
            if (lastIndex == -1 || array[lastIndex][1] < intervals[i][0]) {
                array[++lastIndex] = intervals[i];
            } else {
                //说明和前一组元素有交集,要将当前值合并到结果数组中去 [1,4]    [2,3] 比较 3和4
                array[lastIndex][1] = Math.max(array[lastIndex][1], intervals[i][1]);
            }
        }
        //拷贝多长的元素走
        return Arrays.copyOf(array, lastIndex + 1);
    }
}


