package solutions.dp;

/**
 * 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * @author chujunjie
 * @date Create in 10:52 下午 2020/4/27
 * @Modified by
 */
public class Solution518 {

    /**
     * 状态：【当前可选的硬币】和【金额数】
     * 选择：【是否放进背包】
     * base case: dp[..][0] = 1;
     *
     * @param amount amount
     * @param coins  coins
     * @return int
     */
    private static int change(int amount, int[] coins) {
        // 只使用coins中的前i个硬币，若想凑出金额j，有dp[i][j]种组合
        int[][] dp = new int[coins.length + 1][amount + 1];

        // base case
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    private static int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j - coin >= 0) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(change(5, coins));
        System.out.println(change2(5, coins));
    }
}
