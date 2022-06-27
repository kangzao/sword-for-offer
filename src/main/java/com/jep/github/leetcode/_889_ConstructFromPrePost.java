package com.jep.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2022-05-12 9:12 下午
 */
public class _889_ConstructFromPrePost {

  Map<Integer, Integer> map = new HashMap<>();

  public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    //pre:1 245 367  post:452  673  1
    for (int i = 0; i < postorder.length; i++) {
      map.put(postorder[i], i);
    }
    return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
  }

  public TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart,
      int postEnd) {

    if (preStart > preEnd) {
      return null;
    }
    //遍历到前序遍历的最后一个元素上，后面没有元素了，所以直接返回，否则int leftRootVal = preorder[preStart + 1]要报数组越界的错误
    if (preStart == preEnd) {
      return new TreeNode(preorder[preStart]);
    }
    //初始化根节点
    int rootVal = preorder[preStart];

    int leftRootVal = preorder[preStart + 1];//左子树的值

    //根据前序第二个元素确定左子树长度：该长度为该元素在postorder中的位置 + 1
    int index = map.get(leftRootVal);
    int leftLen = index - postStart + 1;

    TreeNode root = new TreeNode(rootVal);
    root.left = build(preorder, preStart + 1, preStart + leftLen, postorder, postStart, index);
    root.right = build(preorder, preStart + leftLen + 1, preEnd, postorder, index + 1, postEnd - 1);
    return root;

  }

}
