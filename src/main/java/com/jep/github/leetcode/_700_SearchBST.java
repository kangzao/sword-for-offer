package com.jep.github.leetcode;

/**
 * @author enping
 * @date 2021/1/4 下午9:58
 **/
public class _700_SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
