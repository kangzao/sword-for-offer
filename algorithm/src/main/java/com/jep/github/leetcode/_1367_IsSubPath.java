package com.jep.github.leetcode;

import com.jep.github.swordForOffer.ListNode;

/*
 * @author: enping.jep
 * @create: 2022-05-17 8:59 下午
 */
public class _1367_IsSubPath {

  //以root为根节点的子树中是否匹配到链表，不一定从root开始，root不一定必选
  public boolean isSubPath(ListNode head, TreeNode root) {
    if (head == null) {//说明链表遍历完了,说明匹配到了
      return true;
    }
    if (root == null) {//链表没有遍历完，但是树却已经搜索完了，还没有匹配到
      return false;
    }
    //分两种情况，从root开始匹配，即：选中root或者不选root
    return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);

  }

  //以root为根的树中，是否存在子树和链表匹配，root必选
  public boolean dfs(ListNode head, TreeNode root) {
    if (head == null) {//说明链表遍历完了,说明匹配到了
      return true;
    }
    if (root == null) {//链表没有遍历完，但是树却已经搜索完了，还没有匹配到
      return false;
    }
    if (root.val != head.val) {
      return false;
    }
    //依次向下比较
    return dfs(head.next, root.left) || dfs(head.next, root.right);

  }
}
