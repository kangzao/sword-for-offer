package com.jep.github.leetcode;



/*
 * @author: enping.jep
 * @create: 2022-05-26 4:22 下午
 * 给一个二叉搜索树前序遍历的数组，还原这颗二叉搜索树
 */
public class _1008_BstFromPreorder {

  //preorder = [8, 5,1,7, 10,12]
  public TreeNode bstFromPreorder(int[] preorder) {
    return build(preorder, 0, preorder.length - 1);
  }

  public TreeNode build(int[] preorder, int start, int end) {
    if (start > end) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[start]);
    if (start == end) {
      return root;
    }
    //确定左子树范围,二叉搜索树,左子树的值均小于根节点，右子树的值均大于根节点
    //防止两个节点的情况，所以i = start，而不是i = start + 1
    int i = start;
    //i + 1 <= end必须写在前面，防止preorder[i + 1]数组越界
    while (i + 1 <= end && preorder[i + 1] < preorder[start]) {
      i++;
    }
    //preorder = [8, 5,1,7, 10,12]
    root.left = build(preorder, start + 1, i);
    root.right = build(preorder, i + 1, end);
    return root;
  }

}
