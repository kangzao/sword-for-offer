package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2019/12/11
 * @create 2019-12-11 12:33 PM
 */

//二叉树的下一个结点
// 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
// 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。

//中序遍历：左子树---> 根结点 ---> 右子树
public class _07_NextNodeInBinaryTrees {


  public static BinaryTreeNode getNext(BinaryTreeNode pNode) {
    return null;
  }

  public static void main(String args[]) {

    //            1
    //          // \\
    //         2     3
    //       // \\
    //      4     5
    //    inorder->42513
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.left.father = root;
    root.right = new BinaryTreeNode(3);
    root.right.father = root;
    root.left.left = new BinaryTreeNode(4);
    root.left.left.father = root.left;
    root.left.right = new BinaryTreeNode(5);
    root.left.right.father = root.left;
    System.out.println(root);

  }
}
