package com.jep.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @author: enping.jep
 * @create: 2022-06-06 3:47 下午
 */
public class _173_BSTIterator {

  Deque<TreeNode> deque = new ArrayDeque<>();

  public _173_BSTIterator(TreeNode root) {
    //左子树的左节点全部入栈
    TreeNode cur = root;
    while (cur != null) {
      deque.push(cur);
      cur = cur.left;
    }
  }

  public int next() {
    //出栈时，从最左侧节点出
    TreeNode node = deque.pop();
    //出栈时按照中序遍历顺序出栈,最左侧节点可能有右子树，此时应该将右子树的所有左节点加入栈中
    if (node.right != null) {
      TreeNode cur = node.right;
      while (cur != null) {
        deque.push(cur);
        cur = cur.left;
      }
    }

    return node.val;
  }

  public boolean hasNext() {
    return !deque.isEmpty();
  }

}
