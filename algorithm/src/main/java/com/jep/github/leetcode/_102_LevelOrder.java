package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2020-08-26 10:36 AM
 *
 * [
      [3],
      [9,20],
      [15,7]
   ]
 *
 */
public class _102_LevelOrder {

  public static List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        list.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      res.add(list);
    }

    return res;

  }


  public static void main(String args[]) {
    /*
             3
            / \
           9   20
               /\
              15 7
     */
    TreeNode treeNode3 = new TreeNode(15);
    TreeNode treeNode4 = new TreeNode(7);
    TreeNode treeNode1 = new TreeNode(9);
    TreeNode treeNode2 = new TreeNode(20);
    treeNode1.left = treeNode3;
    treeNode2.right = treeNode4;
    TreeNode root = new TreeNode(3, treeNode1, treeNode2);

    List<List<Integer>> list = levelOrder(root);
    System.out.println(list);


  }

}
