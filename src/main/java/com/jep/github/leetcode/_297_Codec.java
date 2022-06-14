package com.jep.github.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @author: enping.jep
 * @create: 2021-01-05 5:13 下午
 * 二刷：2022年05月28日11:52:48
 * 三刷：2022年06月13日20:49:30
    5
   / \
  3   6
 / \   \
1   4   7
 */
public class _297_Codec {


  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeTree(root, sb);
    return sb.toString();
  }

  public void serializeTree(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append("#").append(",");
      return;
    }
    sb.append(node.val).append(",");
    serializeTree(node.left, sb);
    serializeTree(node.right, sb);
  }


  public TreeNode deserialize(String data) {
    String[] dataArray = data.split(",");
    return build(dataArray);
  }

  int i = 0;

  public TreeNode build(String[] dataArray) {
    if (dataArray[i].equals("#")) {
      i++;
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(dataArray[i++]));
    root.left = build(dataArray);
    root.right = build(dataArray);
    return root;
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

    _297_Codec codec = new _297_Codec();
    System.out.println(codec.serialize(root));

  }

}
