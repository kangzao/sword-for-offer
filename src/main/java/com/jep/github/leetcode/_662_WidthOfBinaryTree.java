package com.jep.github.leetcode;

import apple.laf.JRSUIUtils.Tree;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @author: enping.jep
 * @create: 2021-07-12 3:34 下午
 */
public class _662_WidthOfBinaryTree {

  public int widthOfBinaryTree(TreeNode root) {
    int res = 0;
    //根据满二叉树的性质，如果根节点的索引位置是i，左子节点的位置是2*i,右子节点的索引是2*i+1
    Deque<TreeNode> nodeDeque = new ArrayDeque<>();
    Deque<Integer> indexDeque = new ArrayDeque<>();
    //初始化队列的值
    nodeDeque.offer(root);
    indexDeque.offer(1);
    while(!nodeDeque.isEmpty()){
      int start = 0,end = 0;
      int len = nodeDeque.size();
      for(int i = 0; i < len; i++){
        TreeNode node = nodeDeque.poll();
        int index = indexDeque.poll();
        if(i == 0) start = index; //每一层第一个元素
        if(i == len - 1) end = index;//层序遍历到最后一个时，记录最后一个位置的索引
        if(node.left != null){
          nodeDeque.offer(node.left);
          indexDeque.offer(2 * index);
        }
        if(node.right != null){
          nodeDeque.offer(node.right);
          indexDeque.offer(2 * index + 1);
        }
      }
      res = Math.max(res,end - start + 1);
    }
    return res;
  }


  /**
   *            1
   *          /   \
   *         3     2
   *        / \     \
   *       5   3     9
   * @param args
   */
  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);

    TreeNode left = new TreeNode(3);
    TreeNode right = new TreeNode(2);
    left.left = new TreeNode(5);
    left.right = new TreeNode(3);
    right.right = new TreeNode(9);
    root.left = left;
    root.right = right;
    _662_WidthOfBinaryTree  widthOfBinaryTree = new _662_WidthOfBinaryTree();
    int res = widthOfBinaryTree.widthOfBinaryTree(root);
    System.out.println(res);

  }

}
