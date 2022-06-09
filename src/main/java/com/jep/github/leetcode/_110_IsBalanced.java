package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-04-08 3:51 下午
 */
public class _110_IsBalanced {

  /**
   * 类似于二叉树的前序遍历，即对于当前遍历到的节点，首先计算左右子树的高度，如果左右子树的高度差是否不超过 11，
   * 再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。这是一个自顶向下的递归的过程。
   */
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(
        root.right);
  }

  /**
   * 计算root节点的高度
   **/
  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    return Math.max(height(left), height(right)) + 1;
  }

  /**
   * 自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。 如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回
   * -1−1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
   */

  public boolean isBalanced_better(TreeNode root) {
    if (root == null) {
      return true;
    }
    return getHeight(root) > 0;


  }

  //自底向上进行判断，如果当前节点不是平衡树，返回-1,如果是则返回高度
  public int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
      return -1;
    } else {
      return Math.max(left, right) + 1;
    }

  }
}
