package com.jep.github.leetcode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class _449_Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();


  }

  private void serialize(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append(root.val).append(",");
    serialize(root.left, sb);
    serialize(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null) {
      return null;
    }
    String[] arr = data.split(",");
    return deserialize(arr, 0, arr.length - 1);
  }

  //前序遍历还原，比如： 5 314 768
  public TreeNode deserialize(String[] arr, int left, int right) {
    if (left > right) {
      return null;
    }
    int val = Integer.parseInt(arr[left]);
    TreeNode root = new TreeNode(val);
    int i = left + 1;
    while (i <= right && Integer.parseInt(arr[i]) < val) {
      i++;
    }
    root.left = deserialize(arr, left + 1, i - 1);
    root.right = deserialize(arr, i, right);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;