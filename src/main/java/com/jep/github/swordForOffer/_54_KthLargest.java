package com.jep.github.swordForOffer;

import com.jep.github.leetcode.TreeNode;
import java.util.LinkedList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-09 12:39 下午
 */
public class _54_KthLargest {

  int n = 0, ans = -1;

  public int kthLargest(TreeNode root, int k) {
    n = k;
    dfs(root);
    return ans;

  }

  public void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.right);
    //根据二叉搜索树特性，从大往小遍历，第k大的元素就是第k个节点的值
    if (--n == 0) {
      ans = root.val;
      return;
    }
    dfs(root.left);
  }


  /**
   * 5 / \ 3   6 / \   \ 2   4   7
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
    System.out.println("result ==" + kthLargest.kthLargest(root, 3));
  }


}
