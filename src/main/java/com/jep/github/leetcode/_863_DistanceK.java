package com.jep.github.leetcode;

import apple.laf.JRSUIUtils.Tree;
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

  //距离为K的计算方式有三种：向左子树、右子树和向上通过父节点计算，考虑使用三路递归来做
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    getParent(root);
    calDistance(target, null, 0, k);
    return res;
  }

  //遍历节点，记录每个节点的父节点
  public void getParent(TreeNode root) {
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
    getParent(root.left);
    getParent(root.right);
  }

  //计算从target出发，沿着左子树、右子树、父节点搜索的情况,每进行一次查找node和distance都要更新
  public void calDistance(TreeNode node, TreeNode from, int distance, int k) {
    System.out.println(from);
    if (node == null) {
      return;
    }
    if (distance == k) {
      res.add(node.val);
    }
    //防止走回头路,排除向上走再向下走，最后回到target的情况出现
    if (node.left != from) {
      calDistance(node.left, node, distance + 1, k);
    }
    if (node.right != from) {
      calDistance(node.right, node, distance + 1, k);
    }
    TreeNode parent = map.get(node.val);
    if (parent != from) {
      calDistance(parent, node, distance + 1, k);
    }

  }


}
