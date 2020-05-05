package solutions.dp;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 应用场景：
 * 1.修改公众号文章，最少编辑次数
 * 2.DNA序列编辑
 *
 * @author chujunjie
 * @date Create in 11:12 下午 2020/5/4
 * @Modified by
 */
public class Solution72 {

    /**
     * 状态：【word1前i个字符】和【word2前j个字符】
     * 选择：【当前字符是否相等】
     * base case: dp[i][0] = i; dp[0][j] = j;
     *
     * @param word1 word1
     * @param word2 word2
     * @return int
     */
    private static int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m * n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = leftDown;
                } else {
                    dp[i][j] = Math.min(Math.min(left, down), leftDown + 1);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 递归
     *
     * @param word1 word1
     * @param word2 word2
     * @return int
     */
    private static int minDistance(String word1, String word2) {
        int tail1 = word1.length() - 1;
        int tail2 = word2.length() - 1;
        return dp(word1, word2, tail1, tail2);
    }

    private static int dp(String word1, String word2, int index1, int index2) {
        if (index1 == -1) {
            return index2 + 1;
        }

        if (index2 == -1) {
            return index1 + 1;
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return dp(word1, word2, index1 - 1, index2 - 1);
        } else {
            return Math.min(Math.min(dp(word1, word2, index1 - 1, index2) + 1,
                    dp(word1, word2, index1, index2 - 1) + 1),
                    dp(word1, word2, index1 - 1, index2 - 1) + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance2("horse", "ros"));
    }
}
