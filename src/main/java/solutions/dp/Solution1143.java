package solutions.dp;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * @author chujunjie
 * @date Create in 10:02 下午 2020/4/28
 * @Modified by
 */
public class Solution1143 {

    /**
     * 状态：【text1已选字符】和【text2已选字符】
     * 选择：【当前字符是否相等】
     * base case: dp[0] = 1;
     *
     * @param text1 text1
     * @param text2 text2
     * @return int
     */
    private static int longestCommonSubsequence(String text1, String text2) {

        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int m = text1.length();
        int n = text2.length();

        // text1的前i个字符和text2的前j个字符，公共子序列的长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
