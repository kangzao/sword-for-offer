package com.jep.github.nowcoder.tree;

/*
 * @author: enping.jep
 * @create: 2022-06-01 3:47 下午
 * @Link: https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e
 *
 * 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 *
 *       A
 *    b     c
 * d    e     f
 *    g   h
 */
public class GetNext {

  public TreeLinkNode getNext(TreeLinkNode pNode) {
    if (pNode == null) {
      return null;
    }
    //如果有右子树，则返回右子树最左侧的节点，比如b的下一个节点是g
    if (pNode.right != null) {
      TreeLinkNode right = pNode.right;
      while (right.left != null) {
        right = right.left;
      }
      return right;
    }

    //如果没有右子树，分两种情况:第一种是位于父节点的左子树，比如：g
    if (pNode.next != null && pNode.next.left == pNode) {
      return pNode.next;
    }
    //第二种是位于父节点的右子树，比如h 该节点为父节点的右子节点，则沿着父节点向上遍历，直到找到一个节点的父节点的左子节点为该节点，
    // 则该节点的父节点下一个节点（如图节点 h ，沿着父节点一直向上查找找到 B （ B 为其父节点的左子节点），则 B 的父节点 A 为下一个节点）。
    if (pNode.next != null && pNode.next.right == pNode) {
      while (pNode.next != null && pNode.next.left != pNode) {
        pNode = pNode.next;
      }
      return pNode.next;
    }
    return null;
  }

}
