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


//            1
//          // \\
//         2     3
//       // \\
//      4     5
//          // \\
//         6     7
//    inorder->4265713
public class _07_NextNodeInBinaryTrees {


  public static BinaryTreeNode getNext(BinaryTreeNode pNode) {
    if (pNode == null) {
      return pNode;
    }
    // 如果当前结点右子树不空，那么中序下一个结点是右子树的最左子结点（如果有的话）
    BinaryTreeNode right = pNode.right;
    if (right != null) {
      while (right.left != null) {
        right = right.left;
      }
      return right;
    }

    while (pNode.father != null) {
      if (pNode == pNode.father.left) {
        // 节点没有右孩子，当前节点是父节点的左孩子。那么下一个节点就是父节点
        // 当前节点是父节点的右孩子，将节点上移，直到满足：没有右孩子，当前节点是父节点的左孩子
        return pNode.father;
      }
      pNode = pNode.father;

    }
    return null;
  }

  public static void main(String args[]) {

    //            1
    //          // \\
    //         2     3
    //       // \\
    //      4     5
    //          // \\
    //         6     7
    //    inorder->4265713
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(2);
    root.left.father = root;
    root.right = new BinaryTreeNode(3);
    root.right.father = root;
    root.left.left = new BinaryTreeNode(4);
    root.left.left.father = root.left;
    root.left.right = new BinaryTreeNode(5);
    root.left.right.father = root.left;
    root.left.right.left = new BinaryTreeNode(6);
    root.left.right.left.father = root.left.right;
    root.left.right.right = new BinaryTreeNode(7);
    root.left.right.right.father = root.left.right;
    System.out.println(getNext(root.left.left).value);
    System.out.println(getNext(root.left).value);
    System.out.println(getNext(root.left.right).value);
    System.out.println(getNext(root).value);
    System.out.println(getNext(root.right));

  }
}
