package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-05 3:43 下午
 */
public class _98_IsValidBST {

  public boolean isValidBST(TreeNode root) {

    return isValidBST(root, null, null);
  }

  //  函数表示考虑以 root 为根的子树，判断子树中所有节点的值是否都在 (l,r)的范围内（注意是开区间）
  //  如果 root 节点的值 val 不在 (l,r)(l,r) 的范围内说明不满足条件直接返回，否则我们要继续递归调用检查它的左右子树是否满足，
  //  如果都满足才说明这是一棵二叉搜索树。

  public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
    if (root == null) {
      return true;
    }
    if (min != null && root.val <= min.val) {
      return false;
    }
    if (max != null && root.val >= max.val) {
      return false;
    }
    return isValidBST(root.left, null, root) && isValidBST(root.right, root, null);
  }

  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(6);
    _98_IsValidBST isValidBSTInstance = new _98_IsValidBST();
    isValidBSTInstance.isValidBST(root, null, null);

  }

}
