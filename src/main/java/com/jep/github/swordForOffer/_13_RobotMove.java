//package com.jep.github.swordForOffer;
//
///**
// * author jiangenping
// * 2019/12/1 下午2:30
// */
//
//// 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
//// 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
//// 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
//// 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//public class _13_RobotMove {
//
//    public static int movingCount(int m, int n, int k) {
//        int count = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < m; j++) {
//                if (dfs(m, n, k, i, j)) {
//                    count++;
//                }
//            }
//        }
//        return count;
//
//
//    }
//
//    public static boolean dfs(int m, int n, int k, int x, int y) {
//        int step = x / 10 + x % 10 + y / 10 + y % 10;
//        if (step <= k) {
//            return true;
//        }
//        //上右下左
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//        for (int i = 0; i < 4; i++) {
//            x += dx[i];
//            y += dy[i];
//            if (x <= m && y <= n) {
//                dfs(m, n, k, x, y);
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//        int n = 35;
//        System.out.println(35 / 10);
//    }
//}
