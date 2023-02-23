package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2020-12-02 12:27 PM
 *
 * [5,6,3,2,4,1]
 */
public class _590_PostOrder {

  public static List<Integer> postorder(Node root) {
    //后续遍历
    List<Integer> result = new ArrayList<>();
    traversal(root, result);
    return result;

  }


  //递归
  public static void traversal(Node root, List<Integer> result) {
    if (root == null) {
      return;
    }

    if (root.children != null) {
      for (int i = 0; i < root.children.size(); i++) {
        traversal(root.children.get(i), result);
      }
    }
    result.add(root.val);

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

    System.out.println(postorder(root));

  }

}
