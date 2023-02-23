package com.jep.github.swordForOffer;

/**
 * author jiangenping
 * 2019/11/30 下午4:49
 */

// 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
// 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
// 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
// 该格子。
//
// 例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
// 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
// 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
// A B T G
// C F C S
// J D E H

public class _12_StringPathInMatrix {

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] path) {
        if (matrix == null || rows < 1 || cols < 1 || path == null) {
            return false;
        }
//        创建一个辅助数组来确定每个位置是否是字符串中的字符，如果是，则为true，如果不是，则为false，初始数组都为false；
        boolean[] isVisited = new boolean[rows * cols];

//        创建一个变量来储存当前路径的长度
        int currentPathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathFromStartPoint(matrix, rows, cols, row, col, path, currentPathLength, isVisited))
                    return true;
            }
        }
        return false;
    }

    /**
     * @param matrix           矩阵
     * @param rows             总行数
     * @param cols             总列数
     * @param row              当前行
     * @param col              当前列
     * @param path              路径
     * @param currentPathLength 已经处理的路径长度
     * @param isVisited         矩阵中每个格子是否被访问
     * @return
     */
    private static boolean hasPathFromStartPoint(char[] matrix, int rows, int cols, int row, int col, char[] path, int currentPathLength,
                                                 boolean[] isVisited) {

        //矩阵中的索引位置
        int index = row * cols + col;
        //判断是否在矩阵范围内，同时判断该坐标是否被访问过
        if (row < 0 || row >= rows || col < 0 || col >= cols || isVisited[row * cols + col] || path[currentPathLength] != matrix[index]) {
            return false;
        }

        //结束条件 当前长度和字符串长度一样时，说明已经完成了，直接返回true；
        if (currentPathLength == path.length - 1) {
            return true;
        }

        //向四个方向寻找和path匹配的点
        boolean hasPath = false;

        hasPath = hasPathFromStartPoint(matrix, rows, cols, row + 1, col, path, currentPathLength + 1, isVisited) ||
                hasPathFromStartPoint(matrix, rows, cols, row - 1, col, path, currentPathLength + 1, isVisited) ||
                hasPathFromStartPoint(matrix, rows, cols, row, col + 1, path, currentPathLength + 1, isVisited) ||
                hasPathFromStartPoint(matrix, rows, cols, row, col - 1, path, currentPathLength + 1, isVisited);
        //如果找到则设置被访问的标志为true
        if (hasPath) {
            isVisited[index] = true;
        }
        return hasPath;
        //子问题
        //合并结果
        //更改状态
    }

    public static void main(String[] args) {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;

        char[] str = "BFCE".toCharArray();
        System.out.println(hasPath(matrix, rows, cols, str));

        char[] str1 = "BFDH".toCharArray();
        System.out.println(hasPath(matrix, rows, cols, str1));
    }
}


//    void f()
//    {
//        if(符合边界条件)
//        {
//            ///////
//            return;
//        }
//
//        //某种形式的调用
//        f();
//    }