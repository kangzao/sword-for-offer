package com.jep.github.leetcode;

import com.jep.github.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-12-31 7:35 上午
 */
public class _230_KthSmallest {

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> result = new ArrayList<Integer>();
    traversal(root, result);
    return result.get(k - 1);
  }

  public void traversal(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    traversal(root.left, result);
    result.add(root.val);
    traversal(root.right, result);
  }
}
