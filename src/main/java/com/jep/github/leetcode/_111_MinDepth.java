package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-13 7:43 下午
 */
public class _111_MinDepth {

//  public int minDepth(TreeNode root) {
//    if (root == null) {
//      return 0;
//    }
//    int leftDepth = minDepth(root.left);
//    int rightDepth = minDepth(root.right);
//
//    return root.left == null || root.right == null ? leftDepth + rightDepth + 1
//        : Math.min(leftDepth, rightDepth) + 1;
//
//  }


  public int minDepth_1(TreeNode root) {

    int res = Integer.MAX_VALUE;
    if (root.left == null && root.right == null) {
      return 1;
    }
    if (root.left != null) {
      res = Math.min(minDepth_1(root.left), res);
    }

    if (root.right != null) {
      System.out.println(root.val + "before res==" + res);
      res = Math.min(minDepth_1(root.right), res);
      System.out.println(root.val + "after res==" + res);
    }

    return res + 1;
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(5);
    root.right.right.right.right = new TreeNode(6);
    _111_MinDepth minDepth = new _111_MinDepth();
    System.out.println(minDepth.minDepth_1(root));
  }

}
