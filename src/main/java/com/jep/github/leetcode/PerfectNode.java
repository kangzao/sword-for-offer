package com.jep.github.leetcode;

/*
 * @author: enping.jep
 * @create: 2020-12-08 7:57 PM
 * 完美二叉树
 */

public class PerfectNode {

  public int val;
  public PerfectNode left;
  public PerfectNode right;
  public PerfectNode next;

  public PerfectNode() {
  }

  public PerfectNode(int _val) {
    val = _val;
  }

  public PerfectNode(int _val, PerfectNode _left, PerfectNode _right, PerfectNode _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }

}
