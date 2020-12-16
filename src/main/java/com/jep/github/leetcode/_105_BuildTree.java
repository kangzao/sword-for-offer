package com.jep.github.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2020-12-11 9:06 AM
 *
 * 前序遍历 preorder = [3,9,4,2,20,15,7]
   中序遍历 inorder = [4,9,2,3,15,20,7]
       3
     /   \
    9     20
   / \   /  \
  4   2   15   7
 */
public class _105_BuildTree {

    Map<Integer, Integer> map = new HashMap<>();

    //存放中序遍历的索引位置
    private void buildMap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }

    /**
     * @param preorder 前序
     * @param inorder  中序
     * @param preStart 前序的开始
     * @param preEnd   前序的结束
     * @param inStart  中序的开始位置
     * @param inEnd    中序的j结束位置
     * @return 根节点
     */
    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart,
                          int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        //前序遍历的开始节点一定是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        //获取中序遍历中的根节点位置
        int rootIndex = map.get(rootVal);
        //计算左子树的的长度
        int leftTreeLen = rootIndex - inStart;

        //构建左子树
        root.left = build(preorder, inorder, preStart + 1, preStart + leftTreeLen, inStart, rootIndex - 1);
//        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);


        root.right = build(preorder, inorder, preStart + leftTreeLen + 1, preEnd, rootIndex + 1, inEnd);
//        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);


        return root;


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        buildMap(inorder);
        int n = preorder.length;
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(String[] args) {
   /*
             3
            / \
           9   20
               /\
              15 7
     */
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        treeNode1.left = treeNode3;
        treeNode2.right = treeNode4;
        TreeNode root = new TreeNode(3, treeNode1, treeNode2);

        _105_BuildTree buildTree_obj = new _105_BuildTree();
        buildTree_obj.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
