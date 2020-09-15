package com.jep.github.leetcode;

import java.util.List;

/**
 * author jiangenping
 * 2020/8/26 下午10:39
 */

public class _124_MaxPathSum {

    private static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        max = dfs(root);
        return max;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int res = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(max, Math.max(res, root.val + left + right));
        return res;
    }


    public static void main(String[] args) {

        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        treeNode1.left = treeNode3;
        treeNode2.right = treeNode4;
        TreeNode root = new TreeNode(3, treeNode1, treeNode2);


        System.out.println(dfs(root));

    }
}
