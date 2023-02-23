package com.jep.github.swordForOffer;

/*
 * @author: enping.jep
 * @date: 2020/1/16
 * @create 2020-01-16 8:20 AM
 *
 */
public class _19_RegularExpressions_02 {

  /**
   * 动态规划法求解
   */
  public static boolean isMatch(String str, String pattern) {
    if (str == null || pattern == null) {
      return false;
    }

    int m = str.length();
    int n = pattern.length();
    //result[m][n]表示从0到m 是否 和0到n匹配
    boolean result[][] = new boolean[m + 1][n + 1];
    //空字符串相等
    result[0][0] = true;
    //result[i][0] = false(which is default value of the boolean array) since empty pattern cannot match non-empty string
    //result[0][j]: what pattern matches empty string ""? It should be #*#*#*#*...

//    for (int i = 0; i < p.length(); i++) {
//      if (p.charAt(i) == '*' && dp[0][i - 1]) {
//        dp[0][i + 1] = true;
//      }
//    }
    //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
    //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
    for (int j = 2; j < n + 1; j = +2) {
      if (pattern.charAt(j - 1) == '*') {
        result[0][j - 1] = true;
      }
    }

//    for (int i = 0; i < m; i++) {
//      char charStr = str.charAt(i);
//      for (int j = 0; j < n; j++) {
//        char charPattern = pattern.charAt(j);
//        if (charPattern == '.' || charStr == charPattern) {
//          result[i + 1][j + 1] = result[i][j];
//        }
//        if (charPattern == '*') {
//          if (pattern.charAt(j - 1) != '.' && charStr != pattern.charAt(j - 1)) {
//            // #*当做空
//            result[i + 1][j + 1] = result[i][j + 1 - 2];
//          } else {
//            // #*出现 0次 一次 或者 多次
//            result[i + 1][j + 1] =
//                result[i + 1][j + 1 - 2] || result[i + 1 - 1][j + 1 - 2] || result[i + 1 - 1][j
//                    + 1];
//          }
//        }
//      }
//    }
    return result[m][n];
  }


  static void test(String testName, String str, String pattern, boolean expected) {
    if (testName != null) {
      System.out.format("%s begins: ", testName);
    }

    if (isMatch(str, pattern) == expected) {
      System.out.print("Passed.\n");
    } else {
      System.out.print("FAILED.\n");
    }
  }


  public static void main(String[] args) {
//    test("Test01", "", "", true);
    test("Test02", "", ".*", true);
//    test("Test03", "", ".", false);
//    test("Test04", "", "c*", true);
//    test("Test05", "a", ".*", true);
//    test("Test06", "a", "a.", false);
//    test("Test07", "a", "", false);
//    test("Test08", "a", ".", true);
//    test("Test09", "a", "ab*", true);
//    test("Test10", "a", "ab*a", false);
//    test("Test11", "aa", "aa", true);
//    test("Test12", "aa", "a*", true);
//    test("Test13", "aa", ".*", true);
//    test("Test14", "aa", ".", false);
//    test("Test15", "ab", ".*", true);
//    test("Test16", "ab", ".*", true);
//    test("Test17", "aaa", "aa*", true);
//    test("Test18", "aaa", "aa.a", false);
//    test("Test19", "aaa", "a.a", true);
//    test("Test20", "aaa", ".a", false);
//    test("Test21", "aaa", "a*a", true);
//    test("Test22", "aaa", "ab*a", false);
//    test("Test23", "aaa", "ab*ac*a", true);
//    test("Test24", "aaa", "ab*a*c*a", true);
//    test("Test25", "aaa", ".*", true);
//    test("Test26", "aab", "c*a*b", true);
//    test("Test27", "aaca", "ab*a*c*a", true);
//    test("Test28", "aaba", "ab*a*c*a", false);
//    test("Test29", "bbbba", ".*a*a", true);
//    test("Test30", "bcbbabab", ".*a*a", false);
//    test("Test31", "accbb", "a.*ee", false);
//    test("Test32", "accbb", "a.*bb", true);
  }

}
