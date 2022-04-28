package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-04-28 1:38 下午
 */
public class _653_FindTarget {


  /**
   *
   * @param root
   * @param k
   * @return
   * 从递归的角度去考虑这个问题，简单的中序 先序 后序遍历不可能得到AC解，因为这些遍历方式不能遍历所有的可能
   * （基本只能是根节点和当前子树的关系，不同子树的关系无法判断），也就是说，针对每个结点都需要遍历所有的可能，
   * DFS满足这种情况，对于每一个结点，都需要从根结点开始DFS所有的可能
   */

  public boolean findTarget(TreeNode root, int k) {
    return dfs(root, root, k);
  }

  public boolean dfs(TreeNode root, TreeNode cur, int k) {
    if (cur == null) {
      return false;
    }

    if (search(root, cur, k - cur.val)) {
      return true;
    }
    return dfs(root, cur.left, k) || dfs(root, cur.right, k);
  }
  //For each node, we check if k - node.val exists in this BST.
  public boolean search(TreeNode root, TreeNode cur, int value) {
    if (root == null) {
      return false;
    }
    return (root.val == value) && (root != cur)
        || (root.val < value) && search(root.right, cur, value)
        || (root.val > value) && search(root.left, cur, value);
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    System.out.println(new _653_FindTarget().findTarget(root, 4));
  }

}
