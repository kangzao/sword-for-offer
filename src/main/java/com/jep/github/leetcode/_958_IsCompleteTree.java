package com.jep.github.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2021-05-29 10:11 上午
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/hen-jian-dan-de-si-lu-dai-ma-hen-jian-ji-by-yuanyb/
 */
public class _958_IsCompleteTree {

  //思路：把一颗树的节点（包括空节点）按层序遍历排成一行，当且仅当存在两个相邻节点：前一个为null，后一个不为null时，才不是不是完全二叉树。
  public boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode prev = root;
    queue.add(root);
    while (!queue.isEmpty()) {

      TreeNode node = queue.poll();
      if (prev == null && node != null) {
        return false;
      }
      if (node != null) {
        queue.add(node.left);
        queue.add(node.right);
      }
      prev = node;
    }

    return true;
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    TreeNode treeNode1 = new TreeNode(3);
    TreeNode treeNode2 = new TreeNode(6);
    TreeNode treeNode3 = new TreeNode(1);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(7);

    root.left = treeNode1;
    root.right = treeNode2;

    treeNode1.left = treeNode3;
    treeNode1.right = treeNode4;
    treeNode2.right = treeNode5;
    _958_IsCompleteTree isCompleteTreeInstance = new _958_IsCompleteTree();
    isCompleteTreeInstance.isCompleteTree(root);

  }
}
