package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-05-24 4:57 下午
 * 完全二叉树的定义：除最后一层外，其余层全部铺满；且最后一层向左停靠
 * 如果满二叉树的层数为h，则总节点数为：2^h - 1
 */
public class _222_CountNodes {

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = getDepth(root.left);
    int rightDepth = getDepth(root.right);
    //深度相同：这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。
    //所以左子树的节点总数我们可以直接得到，是 2^left - 1，加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。
    if (leftDepth == rightDepth) {
      return (1 << leftDepth) + countNodes(root.right);
      // 如果左子树深度和右子树不相等，则说明左子树深度大于右子树深度(根据完全二叉树的性质，节点向左对齐)
      // 说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。同理，右子树节点 +root 节点，
      // 总数为 2^right。再对左子树进行递归查找。
    } else {
      return (1 << rightDepth) + countNodes(root.left);
    }

  }

  public int getDepth(TreeNode root) {
    int depth = 0;
    //完全二叉树的子树肯定靠左，因此从左侧求树的深度
    while (root != null) {
      root = root.left;
      depth++;
    }
    return depth;
  }
}
