package com.jep.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: enping.jep
 * @create: 2021-04-13 3:03 下午
 */
public class _257_BinaryTreePaths {

  List<String> res = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    dfs(root, new StringBuilder());
    return res;
  }

  //递归函数，遍历整棵树，将符合条件的路径加入到结果中
  public void dfs(TreeNode root, StringBuilder path) {
    if (root == null) {
      return;
    }
    //路径的初始长度
    int len = path.length();
    path.append(root.val);
    //走到了叶子节点，说明已经找到了符合条件的路径，将路径加入到结果集中，如果在这一步就return，必须加上path.setLength(len)
    //因为下面有递归，递归是从下往上返回，递归完左右子树，意味着这颗子树递归完了，此时离开了root节点，向上返回，需要修改path变量
    if (root.left == null && root.right == null) {
      res.add(path.toString());
    } else {
      path.append("->");
      dfs(root.left, path);
      dfs(root.right, path);
    }
    //回溯，递归左子树，当root.left为空的时候，返回到处理root节点的代码，然后递归右子树，root.right为空返回处理root节点的代码，此时root这颗子树处理完毕，接着向上返回到root的父节点：root.root，因此每遍历完一颗子树都要对结果集进行处理
    //这里使用setLength，是因为len的长度如果是变小了，则时间复杂度是O(1),如果是扩大，则为O(n)
    path.setLength(len);
  }
















  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);

    _257_BinaryTreePaths btp = new _257_BinaryTreePaths();
    btp.binaryTreePaths(root);
  }
}
