package com.jep.github.leetcode;

import apple.laf.JRSUIUtils.Tree;
import java.util.Arrays;

/*
 * @author: enping.jep
 * @create: 2020-12-11 9:06 AM
 *
 * 前序遍历 preorder = [3,9,20,15,7]
   中序遍历 inorder = [9,3,15,20,7]
      3
     / \
    9  20
      /  \
     15   7
 */
public class _105_BuildTree {


  public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart,
      int inEnd) {

    TreeNode root = new TreeNode(preorder[preStart]);
    if (preStart > preEnd || inStart > inEnd) {
      return root;
    }
    //从中序遍历找到左右子树
    for (int i = 0; i < inorder.length; i++) {
      if (preorder[preStart] == inorder[i]) {
        //左子树
        TreeNode left = build(preorder, inorder, preStart + 1, preEnd, )
        //右子树
        TreeNode right = build(preorder, inorder, preStart + 1, preEnd, )
        root.left = left;
        root.right = right;
        break;
      }
    }


  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    if (preorder == null || inorder == null) {
      return null;
    }
    int rootIndex = 0;
    int leftIndex = 0;

    while (rootIndex) {
      TreeNode root = new TreeNode(preorder[rootIndex]);
      TreeNode left = new TreeNode(inorder[leftIndex]);

    }

    int rootVal = preorder[0];//
    TreeNode root = new TreeNode(rootVal);

    int rootIndex = -1;

    //获取中序遍历root的位置
    for (int i = 0; i < inorder.length; i++) {

    }
    int[] left = Arrays.copyOfRange()


  }

  public static void main(String args[]) {

  }

}
