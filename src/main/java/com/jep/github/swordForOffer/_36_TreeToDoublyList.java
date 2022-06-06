package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @create: 2022-06-06 2:33 下午
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 */
public class _36_TreeToDoublyList {

  Node pre, head; //定义前驱节点和头结点

  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    dfs(root);
    head.left = pre;
    pre.right = head;
    return head;
  }

  //
  public void dfs(Node root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    //如果前驱节点是空，则说明正在处理第一个节点
    if (pre == null) {
      head = root;
    } else {
      pre.right = root;
    }
    root.left = pre;
    pre = root;
    dfs(root.right);
  }


}
