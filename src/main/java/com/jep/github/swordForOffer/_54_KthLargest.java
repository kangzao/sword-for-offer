package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-09 12:39 下午
 */
public class _54_KthLargest {

  int res, k;

  //中序遍历左、根、右是递增数组,第K大的数字为该数字逆序后的第K个元素,然后直接返回即可。
  public int kthLargest(TreeNode root, int k) {
    this.k = k;
    dfs(root);
    return res;
  }

  void dfs(TreeNode root) {

    if (root == null) {
      return;
    }


    dfs(root.right);
    if (k == 0) {
      return;
    }
    System.out.println(root.val);
    if (--k == 0) {

      res = root.val;
    }
    dfs(root.left);
  }


  /**
   *
   *     5
   *    / \
   *   3   6
   *  / \   \
   * 2   4   7
   */

  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    TreeNode treeNode1 = new TreeNode(3);
    TreeNode treeNode2 = new TreeNode(6);
    TreeNode treeNode3 = new TreeNode(2);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(7);

    root.left = treeNode1;
    root.right = treeNode2;

    treeNode1.left = treeNode3;
    treeNode1.left = treeNode4;
    treeNode2.right = treeNode5;

    _54_KthLargest kthLargest = new _54_KthLargest();
    //节点经过顺序7 - 6 - 5
    System.out.println("result ==" + kthLargest.kthLargest(root,3));
  }


}
