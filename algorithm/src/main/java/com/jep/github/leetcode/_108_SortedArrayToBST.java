package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-12 12:13 下午
 */
public class _108_SortedArrayToBST {

  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(0, nums.length - 1, nums);

  }

  public TreeNode dfs(int start, int end, int[] nums) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = dfs(start, mid - 1, nums);
    root.right = dfs(mid + 1, end, nums);
    return root;
  }

}
