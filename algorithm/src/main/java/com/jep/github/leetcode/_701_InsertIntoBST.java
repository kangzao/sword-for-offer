package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2021-01-04 7:31 下午
 *
 *  5
   / \
  3   6
 / \   \
1   4   7
 */
public class _701_InsertIntoBST {


  public TreeNode insertIntoBST_loop(TreeNode root, int val) {
    TreeNode node = new TreeNode(val);
    if (root == null) {
      return node;
    }
    TreeNode p = root;
    while (true) {
      //当前值比根节点的值大，则说明需要插入到右子树
      if (p.val < val) {
        if (p.right == null) {
          p.right = node;
          break;
        }
        p = p.right;
      } else {

        if (p.left == null) {
          p.left = node;
          break;
        }
        p = p.left;
      }
    }
    return root;
  }


  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    //插入右子树
    if (val > root.val) {
      root.right = insertIntoBST(root.right, val);
    }
    //插入左子树
    else if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    }
    return root;
  }

  public static void main(String args[]) {

    TreeNode root = new TreeNode(5);
    TreeNode treeNode1 = new TreeNode(3);
    TreeNode treeNode2 = new TreeNode(6);
    TreeNode treeNode3 = new TreeNode(1);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(7);

    root.left = treeNode1;
    root.right = treeNode2;

    treeNode1.left = treeNode3;
    treeNode1.right = treeNode4;
    treeNode2.right = treeNode5;

    _701_InsertIntoBST instance = new _701_InsertIntoBST();

    TreeNode treeNode = instance.insertIntoBST(root, 2);
    System.out.println(treeNode);

  }

}
