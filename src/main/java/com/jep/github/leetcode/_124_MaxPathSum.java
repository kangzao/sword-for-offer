package com.jep.github.leetcode;

import java.util.List;

/**
 * author jiangenping 2020/8/26 下午10:39
 */

public class _124_MaxPathSum {

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxVal;

    }

    //从root出发的子树的最大收益
    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //最大收益必须大于0才有意义，0以下的数字都返回0，即：舍弃该节点
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        maxVal = Math.max(maxVal, root.val + leftGain + rightGain);
        //只能返回左子树和右子树的最大值，只能选择一条边，两条边同时选意味着root被经过了两次，不符合提议
        return root.val + Math.max(leftGain, rightGain);

    }
}
