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
    if (key < root.val) {
      //需要从左子树中删除该节点，同时保持左子树为二叉搜索树，重新设置root的左子树
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {//key和root的值相等
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }
      //左子树和右子树都不为空，此时要找到右子树最小的那个值，即：右子树最靠左的叶子节点，然后把左子树接到这个节点后面
      TreeNode rightSmallest = root.right;
      while (rightSmallest.left != null) {
        rightSmallest = rightSmallest.left;
      }
      rightSmallest.left = root.left;
      //删除root，返回新的头结点
      root = root.right;
    }
    return root;
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
