package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-06-16 8:35 下午
 *
 */
public class _99_RecoverTree {

  TreeNode p1 = null, p2 = null, prev = null;

  public void recoverTree(TreeNode root) {

    dfs(root);
    //找到这两个被交换的节点然后交换
    int tmp = p1.val;
    p1.val = p2.val;
    p2.val = tmp;
  }

  public void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);//中序遍历，左中右，利用bst的性质
    if (prev == null) {
      prev = root;//初始化prev
    } else {
      //3,6,9,10,14  如果是14和6交换(非相邻节点交换)：3,14,9,10,6  判断出现非递增的情况 第一个节点应该是更大的那个
      // 6,3,9,10,14 如果是相邻节点交换，同理
      if (prev.val >= root.val && p1 == null) {
        p1 = prev;
      }
      //第二个节点是更小的那个
      if (prev.val >= root.val && p1 != null) {
        p2 = root;
      }
      prev = root;//遍历完了当前节点，prev继续前进
    }
    dfs(root.right);
  }

}
