package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2022-05-26 11:04 上午
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 k 。
 * Node.val 中所有值不同
 */
public class _863_DistanceK {

  Map<Integer, TreeNode> map = new HashMap<>();
  List<Integer> res = new ArrayList<>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    if (root == null) {
      return res;
    }
    getParents(root);
    dfs(target, null, 0, k);
    return res;
  }

  //从target出发，有三种选择，左右上，记录距离target为k的节点
  public void dfs(TreeNode target, TreeNode from, int distance, int k) {
    if (target == null) {
      return;
    }

    if (distance == k) {
      res.add(target.val);
    }
    //向左走，防止向左走了之后再走回来这种情况,判断到达该节点的起始节点，是否是此次要去的节点，如果是，则会走回头路，需要排除
    //不能出现from走到target，再从target走回from的情况
    if (target.left != from) {
      dfs(target.left, target, distance + 1, k);
    }
    if (target.right != from) {
      //向右走
      dfs(target.right, target, distance + 1, k);
    }
    TreeNode parent = map.get(target.val);
    if (parent != from) {
      //向上走
      dfs(map.get(target.val), target, distance + 1, k);
    }
  }

  //建立子节点和父节点之间的映射关系
  public void getParents(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    if (left != null) {
      map.put(left.val, root);
    }
    if (right != null) {
      map.put(right.val, root);
    }
    getParents(root.left);
    getParents(root.right);

  }


}
