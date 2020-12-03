package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-12-03 3:22 PM
 * N叉树的前序遍历
 */
public class _589_Preorder {

  public static List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    traversal(root, result);
    return result;

  }


  public static void traversal(Node root, List<Integer> result) {
    if (root == null) {
      return;
    }
    result.add(root.val);
    if (root.children != null) {
      for (int i = 0; i < root.children.size(); i++) {
        traversal(root.children.get(i), result);
      }
    }

  }

  public static void main(String args[]) {
    Node root = new Node(1);
    List<Node> list = new ArrayList();
    Node subNode = new Node(3);
    list.add(subNode);
    list.add(new Node(2));
    list.add(new Node(4));
    List<Node> subList = new ArrayList();
    subNode.children = subList;
    subList.add(new Node(5));
    subList.add(new Node(6));
    root.children = list;

    System.out.println(preorder(root));
  }

}
