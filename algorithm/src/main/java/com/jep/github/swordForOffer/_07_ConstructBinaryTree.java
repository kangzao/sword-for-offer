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

import com.jep.github.leetcode.TreeNode;
import java.util.HashMap;

//Preorder traversal 前序遍历
//inorder traversal  中序遍历
public class _07_ConstructBinaryTree {

  private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // 缓存中序遍历数组的每个值对应的索引

  /**
   * @param pre 前序遍历数组
   * @param in 中序遍历数组
   * @return 二叉树
   */
  public static TreeNode reConstructBinaryTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  public static TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }
    int val = preorder[preStart];
    TreeNode root = new TreeNode(val);
    //根节点在中序遍历中的索引
    int rootIndex = map.get(val);
    int leftLen = rootIndex - inStart;
    root.left = build(preorder, preStart + 1, preStart + leftLen, inStart, rootIndex - 1);
    root.right = build(preorder, preStart, preStart + leftLen + 1, rootIndex + 1, inEnd);
    return root;

  }

  public static void main(String args[]) {
    int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
    int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
    TreeNode node = reConstructBinaryTree(preorder, inorder);
    System.out.println(node);

  }

}
