package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-12-31 3:10 下午
 *  5
   / \
  3   6
 / \   \
2   4   7
*

*   5
   / \
  4   6
 /     \
2       7
 */
public class _450_DeleteNode {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (root.val == key) {
      //1、删除的节点没有子节点
      if (root.left == null && root.right == null) {
        return null;
      }
      //2、删除的节点只有一个子节点
      if (root.right == null) {
        return root.left;
      }

      if (root.left == null) {
        return root.right;
      }
      //3、处理有两个子节点的情况，需要从左侧选一个最大节点，或者从右侧选一个最小节点替换根节点，然后删除左侧最大或者右侧最小
      TreeNode treeNode = getMin(root.right);
      root.val = treeNode.val;
      root.right = deleteNode(root.right, treeNode.val);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      root.left = deleteNode(root.left, key);
    }
    return root;
  }

  //从右侧节点中找到最小的节点
  public TreeNode getMin(TreeNode right) {
    while (right.left != null) {
      right = right.left;
    }
    return right;

  }


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
  }

}
