package com.jep.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * @author: enping.jep
 * @create: 2022-05-27 5:13 下午
 */
public class _437_PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int sum = dfs(root, targetSum);//从根节点出发寻找路径和
        sum += pathSum(root.left, targetSum);//从左子树出发寻找路径和
        sum += pathSum(root.right, targetSum);//从右子树出发寻找路径和
        return sum;
    }

    //从root出发，向下寻找和为targetSum的链路数量
    public int dfs(TreeNode root, int targetSum) {
        int n = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            n++;
        }
        n += dfs(root.left, targetSum - root.val);
        n += dfs(root.right, targetSum - root.val);
        return n;
    }

    /**
     * 更优解法2
     */

    //使用前缀和，利用hashmap存储每条路径前缀和出现的次数
    Map<Integer, Integer> prefixSum = new HashMap<>();

    public int pathSum_better(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        //如果首个节点就满足root.val == targetSum,此时curSum - targetSum = 0,表示前缀和为0的路径有一个，因此这里要对map初始化
        prefixSum.put(0, 1);
        return recurPathSum(root, 0, targetSum);

    }

    //以root为根的树有多少符合条件的路径
    public int recurPathSum(TreeNode root, int curSum, int targetSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        //从当前节点向上寻找，是否有满足条件的链路，prefixSum存放路径前缀和出现的次数，会将向上的所有链路都找出来
        res += prefixSum.getOrDefault(curSum - targetSum, 0);
        //存放当前节点的前缀和
        prefixSum.put(curSum, prefixSum.getOrDefault(curSum, 0) + 1);
        res += recurPathSum(root.left, curSum, targetSum);
        res += recurPathSum(root.right, curSum, targetSum);
        //当前节点的前缀和只可以用来参与计算到它的左子树和右子树，不能参与到兄弟节点的计算，因此在递归回到当前节点之前，要去除当前节点的前缀和，恢复状态
        prefixSum.put(curSum, prefixSum.get(curSum) - 1);
        return res;

    }
}
