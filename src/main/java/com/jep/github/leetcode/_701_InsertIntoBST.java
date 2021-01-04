package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-04 7:31 下午
 *
 *  5
   / \
  3   6
 / \   \
1   4   7
 */
public class _701_InsertIntoBST {


  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    //插入右子树
    if (val > root.val) {
      root.right = insertIntoBST(root.right, val);
    }
    //插入左子树
    else if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    }
    return root;
  }

  public static void main(String args[]) {

  }

}
