package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-12-17 9:26 上午
 *
 * 给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */


import java.util.HashMap;
import java.util.Map;

public class _106_BuildTree {

  Map<Integer, Integer> inorderMap = new HashMap<>();

  public void buildInorderMap(int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
  }

  /**
   * @param postorder 后序数组
   * @param inStart 中序开始位置
   * @param inEnd 中序结束位置
   * @param postStart 后序开始位置
   * @param postEnd 后序结束位置
   */
  public TreeNode build(int[] postorder, int inStart, int inEnd, int postStart,
      int postEnd) {
    //根据后序遍历结果，找到根节点
    // 中序：9,  3,  15,20,7    根是3 左子树：9  右子树：15,20,7
    // 后序：9,  15,7,20,  3    根是3 左子树：9  右子树：15,7,20
    if (postStart > postEnd || inStart > inEnd) {
      return null;
    }
    int rootVal = postorder[postEnd];
    TreeNode root = new TreeNode(rootVal);
    int inorderRootIndex = inorderMap.get(rootVal);
    //求左子树长度
    int leftLength = inorderRootIndex - inStart;
    root.left = build(postorder, inStart, inorderRootIndex - 1, postStart,
        postStart + leftLength - 1);
    root.right = build(postorder, inorderRootIndex + 1, inEnd, postStart + leftLength,
        postEnd - 1);

    return root;
  }

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null) {
      return null;
    }
    buildInorderMap(inorder);
    int n = inorder.length;
    return build(postorder, 0, n - 1, 0, n - 1);
  }


  public static void main(String args[]) {
    _106_BuildTree buildTree_obj = new _106_BuildTree();
    TreeNode result = buildTree_obj
        .buildTree(new int[]{1, 2}, new int[]{2, 1});
    System.out.println(result);

  }

}
