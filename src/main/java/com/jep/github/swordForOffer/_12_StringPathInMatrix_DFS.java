package com.jep.github.swordForOffer;

/**
 * author jiangenping
 * 2019/12/1 下午12:23
 */

public class _12_StringPathInMatrix_DFS {

    public static boolean hasPath(char[][] matrix, String path) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (dfs(matrix, path, 0, i, j))
                    return true;
        return false;
    }

    /**
     * @param matrix 矩阵
     * @param path   路径
     * @param index  路径的索引位置
     * @param x      矩阵的x坐标
     * @param y      矩阵的y坐标
     * @return
     */
    public static boolean dfs(char[][] matrix, String path, int index, int x, int y) {
        //矩阵中的坐标点和路径中的字符不一致
        if (matrix[x][y] != path.charAt(index)) return false;
        // 索引位置和path的长度一致，则完成查找
        if (index == path.length() - 1) return true;
        // 上：x-1 y不变 下：x+1  y不变 左：y-1 x不变 右：y+1 x不变
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        char t = matrix[x][y];
        //因为在每次dfs的开始会判断if (matrix[x][y] != path.charAt(index)) return false;，
        //而'*'不会匹配给定单词里的任何一个字母，所以如果 matrix[a][b] == ‘*’，就一定会返回false。
        matrix[x][y] = '*';//如果找到了，则这个位置改成*，不能再使用
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i], b = y + dy[i];
            //判断是否在矩阵内
            if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[a].length) {
                //上下左右任一一个点符合条件就退出
                if (dfs(matrix, path, index + 1, a, b)) return true;
            }
        }
        //四个方向没找到恢复现场
        matrix[x][y] = t;
        return false;
    }


    //A B T G
    //C F C S
    //J D E H
    public static void main(String[] args) {
        char[][] matrix = {{'A', 'B', 'T', 'G'}, {'C', 'F', 'C', 'S'}, {'J', 'D', 'E', 'H'}};
        System.out.println(hasPath(matrix, "BFCE"));
        System.out.println(hasPath(matrix, "BFDH"));
    }
}


//    void dfs(int 当前状态)
//    {
//        if(当前状态为边界状态)
//        {
//            记录或输出
//            return;
//        }
//        for(i=0;i<n;i++)		//横向遍历解答树所有子节点
//        {
//            //扩展出一个子状态。
//            修改了全局变量
//            if(子状态满足约束条件)
//            {
//                dfs(子状态)
//            }
//            恢复全局变量//回溯部分
//        }
//    }

//terminator
//process：split your problem
//drill down
//merge
//reverse status