package com.jep.github.leetcode;

import java.util.*;

/*
 * @author: enping.jep
 * @create: 2021-04-25 5:11 下午
 */
public class _199_RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {

            //遍历每一层
            for (int i = deque.size() - 1; i >= 0; i--) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                if (i == 0) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

}
