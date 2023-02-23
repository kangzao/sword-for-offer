package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2022-04-29 5:08 下午
 */
public class _501_FindMode {


  TreeNode pre;//前一个节点
  int max = Integer.MIN_VALUE;//最大频率
  int count;//当前节点的频率
  List<Integer> list = new ArrayList<>();

  public int[] findMode(TreeNode root) {
    dfs(root);
    int[] arr = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }

  public void dfs(TreeNode root) {
    //左根右非递减数字串
    if (root == null) {
      return;
    }
    dfs(root.left);
    if (pre == null) {
      count = 1;//说明是首节点
    } else if (pre.val == root.val) {
      count++;
    } else {
      count = 1;//不相等则出现一次
    }

    if (count == max) {//是最大频率则记录下来
      list.add(root.val);
    } else if (count > max) {//超过最大频率需要更新max，并清空结果，然后记录
      max = count;
      if (!list.isEmpty()) {
        list.clear();
      }
      list.add(root.val);
    }

    pre = root;

    dfs(root.right);
  }

}
