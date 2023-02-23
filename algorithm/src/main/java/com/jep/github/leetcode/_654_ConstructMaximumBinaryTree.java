package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-12-10 7:48 PM
 */
public class _654_ConstructMaximumBinaryTree {


  public static TreeNode constructMaximumBinaryTree(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    return build(nums, 0, nums.length - 1);
  }


  public static TreeNode build(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }

    int maxValue = Integer.MIN_VALUE;

    int index = -1;

    for (int i = start; i <= end; i++) {
      if (nums[i] > maxValue) {
        maxValue = nums[i];
        index = i;
      }
    }
    TreeNode left = build(nums, start, index - 1);
    TreeNode right = build(nums, index + 1, end);

    TreeNode root = new TreeNode(maxValue);
    root.left = left;
    root.right = right;
    return root;
  }

}
