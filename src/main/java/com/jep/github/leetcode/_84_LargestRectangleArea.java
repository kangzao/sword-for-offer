package com.jep.github.leetcode;

import java.util.Stack;

/**
 * author jiangenping
 * 2020/3/7 下午6:00
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/084zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-6westb/
 */

public class _84_LargestRectangleArea {
    //循环嵌套,时间复杂度n^2
    public static int nested_loop(int[] heights) {
        int barCount = heights.length;
        int max = 0;
        for (int i = 0; i < barCount; i++) {
            int tmpHeight = heights[i];
            int tmpWidth = 1;
            //假设当前高度为最小高度，向左找到左边界，向右找到右边界
            for (int left = i - 1; left >= 0 && heights[left] >= tmpHeight; left--) {
                tmpWidth++;
            }
            for (int right = i + 1; right < barCount && heights[right] >= tmpHeight; right++) {
                tmpWidth++;
            }
            max = Math.max(tmpHeight * tmpWidth, max);
        }
        return max;
    }


    public static int largestRectangleArea(int[] heights) {
        //单调递增栈，如果新入栈的元素比栈顶元素小，则新入栈的元素恰为以栈顶元素为高度的右边界
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                //比新高度大的所有元素弹出栈，按照此高度，直接定位左右边界，进行计算。
                maxArea = Math.max(heights[stack.pop()] * (i - stack.peek() - 1), maxArea);
            }
            stack.push(i);
        }
        //如果栈中还有元素
        while (stack.peek() != -1) {
            maxArea = Math.max(heights[stack.pop()] * (heights.length - stack.peek() - 1), maxArea);
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(nested_loop(heights));
        System.out.println(largestRectangleArea(heights));
    }
}
