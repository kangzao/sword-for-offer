package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2022-05-24 3:44 下午
 */

/**
 * 以n=3为例，以1为根 有两种 ，以2为根 有一种 ，以3为根有1种，总共有五种
 * 轮流以每个节点为根的种类求和即为所得
 * 找规律 以1为根，使用2.3构建有两种，以3为根，使用1、2构建也是两种，具体的种类和元素个数相关，和具体的值无关，这里有重复子问题
 * 共有i个节点：
 * 左子树  i    右子树
 *  0     1    i - 1
 *  1          i - 2
 *  .....
 *  i - 1      0
 *  设左子树用掉j个，则右子树用掉i - j - 1个
 *  n = 0，空树
 *  n = 1，单节点的树
 *  dp[i] = dp[0] * dp[i - 1] + dp[1] * dp[i - 2] + ... +dp[i - 1] * dp[0]
 *
 */

//求1-n个节点内有多少中二叉搜索树
public class _96_NumTrees {

  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;//空节点只有一颗树
    dp[1] = 1;//单节点只有一棵树
    for(int i = 2; i <= n; i++){
      for(int j = 0; j <= i - 1; j++){
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }
}
