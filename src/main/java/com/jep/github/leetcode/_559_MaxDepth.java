package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-06-16 9:38 下午
 */
public class _559_MaxDepth {

  //求root的最大深度
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    if (root.children == null) {
      return 1;
    }
    int res = 0;
    for (Node node : root.children) {
      //求每一条路劲的最大深度
      res = Math.max(maxDepth(node), res);
    }
    return res + 1;

  }

}
