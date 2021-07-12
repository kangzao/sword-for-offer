package com.jep.github.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @author: enping.jep
 * @create: 2021-07-12 3:34 下午
 */
public class _662_WidthOfBinaryTree {

  public int widthOfBinaryTree(TreeNode root) {
    int maxLen = 1;
    //广度优先遍历存放节点
    Deque<TreeNode> queue = new LinkedList<>();
    //存放非空节点的索引位置
    Deque<Integer> list = new LinkedList<>();

    list.add(1); //根节点的索引值是i，左子节点的索引是2*i 右子节点索引是2*i+1
    queue.offer(root);
    //层序遍历
    while (!queue.isEmpty()) {
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        int curIndex = list.removeFirst();
        if (node.left != null) {
          queue.offer(node.left);
          list.add(2 * curIndex);
        }
        if (node.right != null) {
          queue.offer(node.right);
          list.add(2 * curIndex + 1);
        }
      }
      //list中的元素最终会在上面的循环结束后变为空，队列为空的时候，getlast会抛出异常NoSuchElementException，因此这里必须加判断
      if (list.size() >= 2) {
        maxLen = Math.max(list.getLast() - list.getFirst() + 1, maxLen);
      }
    }
    return maxLen;
  }

  public static void main(String args[]) {
    TreeNode treeNode3 = new TreeNode(15);
    TreeNode treeNode4 = new TreeNode(7);
    TreeNode treeNode1 = new TreeNode(9);
    TreeNode treeNode2 = new TreeNode(20);
    treeNode1.left = treeNode3;
    treeNode2.right = treeNode4;
    TreeNode root = new TreeNode(3, treeNode1, treeNode2);

    _662_WidthOfBinaryTree width = new _662_WidthOfBinaryTree();
    width.widthOfBinaryTree(root);
  }

}
