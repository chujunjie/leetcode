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
    public static void main(String[] args) {
        System.out.println(dp(new int[]{1, 2, 5}, 11));
    }

    private static int dp(int[] coins, int amount) {
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
}
