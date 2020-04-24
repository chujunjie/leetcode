package solutions.dp;

import java.util.Arrays;

/**
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @Author: chujunjie
 * @Date: Create in 17:13 2020/4/19
 * @Modified By
 */
public class Solution322 {

    private static int ANS = Integer.MAX_VALUE;

    /**
     * 暴力递归
     *
     * @param coins  coins
     * @param amount amount
     * @return int
     */
    private static int dp(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dp(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * 迭代
     *
     * @param coins  coins
     * @param amount amount
     * @return int
     */
    private static int dp2(int[] coins, int amount) {
        int max = amount + 1;
        // 目标金额为i时，至少需要dp[i]个硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * dfs
     *
     * @param coins  coins
     * @param amount amount
     * @return int
     */
    private static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ANS == Integer.MAX_VALUE ? -1 : ANS;
    }

    /**
     * @param coins  待选的硬币面值
     * @param index  当前选择的硬币面值的索引
     * @param amount 需要凑够的金额
     * @param cnt    目前已选的硬币数量
     */
    private static void dfs(int[] coins, int index, int amount, int cnt) {
        if (index < 0) {
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int na = amount - c * coins[index];
            int ncnt = cnt + c;
            if (na == 0) {
                ANS = Math.min(ANS, ncnt);
                // 剪枝1
                break;
            }
            if (ncnt + 1 >= ANS) {
                // 剪枝2
                break;
            }
            dfs(coins, index - 1, na, ncnt);
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(dp(coins, 11));
        System.out.println(dp2(coins, 11));
        System.out.println(coinChange(coins, 11));
    }
}
