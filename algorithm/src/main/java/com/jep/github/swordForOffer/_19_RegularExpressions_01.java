package com.jep.github.swordForOffer;

/**
 * author jiangenping
 * 2019/12/30 下午10:05
 * 递归解法
 */


// 正则表达式匹配
// 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
// 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
// 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
// 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
public class _19_RegularExpressions_01 {

    public static boolean isMatch(String str, String pattern) {
        //递归终止条件
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        // 判断首元素是否一致
        boolean firstMatch = (!str.isEmpty() && (str.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));
        // 处理当前情况
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // 下探到下一层 drilldown
            return (isMatch(str, pattern.substring(2)) || (firstMatch && isMatch(str.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(str.substring(1), pattern.substring(1));
        }
    }

    static void test(String testName, String str, String pattern, boolean expected) {
        if (testName != null)
            System.out.format("%s begins: ", testName);

        if (isMatch(str, pattern) == expected)
            System.out.print("Passed.\n");
        else
            System.out.print("FAILED.\n");
    }


    public static void main(String[] args) {
        test("Test01", "", "", true);
        test("Test02", "", ".*", true);
        test("Test03", "", ".", false);
        test("Test04", "", "c*", true);
        test("Test05", "a", ".*", true);
        test("Test06", "a", "a.", false);
        test("Test07", "a", "", false);
        test("Test08", "a", ".", true);
        test("Test09", "a", "ab*", true);
        test("Test10", "a", "ab*a", false);
        test("Test11", "aa", "aa", true);
        test("Test12", "aa", "a*", true);
        test("Test13", "aa", ".*", true);
        test("Test14", "aa", ".", false);
        test("Test15", "ab", ".*", true);
        test("Test16", "ab", ".*", true);
        test("Test17", "aaa", "aa*", true);
        test("Test18", "aaa", "aa.a", false);
        test("Test19", "aaa", "a.a", true);
        test("Test20", "aaa", ".a", false);
        test("Test21", "aaa", "a*a", true);
        test("Test22", "aaa", "ab*a", false);
        test("Test23", "aaa", "ab*ac*a", true);
        test("Test24", "aaa", "ab*a*c*a", true);
        test("Test25", "aaa", ".*", true);
        test("Test26", "aab", "c*a*b", true);
        test("Test27", "aaca", "ab*a*c*a", true);
        test("Test28", "aaba", "ab*a*c*a", false);
        test("Test29", "bbbba", ".*a*a", true);
        test("Test30", "bcbbabab", ".*a*a", false);
        test("Test31", "accbb", "a.*ee", false);
        test("Test32", "accbb", "a.*bb", true);
    }
}
