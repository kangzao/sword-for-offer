package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/12/16
 * @create 2019-12-16 10:33 AM
 */

//重建二叉树
// 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
// 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}
// 则重建出图所示的二叉树并输出它的头结点。
//                 1
//                / \
//               2   3
//              /   / \
//             4   5   6
//              \     /
//               7   8

import java.util.HashMap;

//Preorder traversal 前序遍历
//inorder traversal  中序遍历
public class _07_ConstructBinaryTree {

  private static HashMap<Integer, Integer> inOrderNumsIdx = new HashMap<Integer, Integer>(); // 缓存中序遍历数组的每个值对应的索引

  /**
   * @param pre 前序遍历数组
   * @param in 中序遍历数组
   * @return 二叉树
   */
  public static BinaryTreeNode reConstructBinaryTree(int[] pre, int[] in) {
    for (int i = 0; i < in.length; i++) {
      inOrderNumsIdx.put(in[i], i);
    }
    return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
  }

  private static BinaryTreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int[] in,
      int inL, int inR) {
    if (preL > preR || inL > inR) {
      return null;
    }
    BinaryTreeNode treeNode = new BinaryTreeNode(pre[preL]);
    int index = inOrderNumsIdx.get(pre[preL]);
    int leftTreeSize = index - inL;//左子树长度
    treeNode.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, in, inL,
        inR + leftTreeSize - 1);
    treeNode.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, in,
        inL + leftTreeSize + 1, inR);
    return treeNode;

  }

  public static void main(String args[]) {
    int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
    int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
    BinaryTreeNode node = reConstructBinaryTree(preorder, inorder);
    System.out.println(node);

  }

}
