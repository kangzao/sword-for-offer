package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-07-12 4:19 下午
 */
public class _145_PostorderTraversal {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    traversal(root, list);
    return list;


  }

  //left right root
  public void traversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    traversal(root.left, list);

    traversal(root.right, list);

    if (root != null) {
      list.add(root.val);
    }

  }

}
