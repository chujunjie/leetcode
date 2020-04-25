package solutions.dp;

/**
 * @Description: 01背包
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * @Author: chujunjie
 * @Date: Create in 21:14 2020/4/25
 * @Modified By
 */
public class SolutionBackpack {

    /**
     * 01背包
     *
     * @param ws    物品重量
     * @param vs    物品价值
     * @param count 物品数量
     * @param sum   背包承重
     * @return 背包所能装的最大价值
     */
    private static int dp(int[] ws, int[] vs, int count, int sum) {
        // 对于前 i 个物品，当前背包的容量为 w 时，这种情况下可以装下的最大价值是 dp[i][w]
        int[][] dp = new int[count + 1][sum + 1];
        for (int i = 1; i <= count; i++) {
            for (int w = 1; w <= sum; w++) {
                // i-1表示第i个物品的价值和重量
                // remain表示剩余重量
                int remain = w - ws[i - 1];
                if (remain < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 剩余重量+物品价值
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][remain] + vs[i - 1]);
                }
            }
        }
        return dp[count][sum];
    }

    public static void main(String[] args) {
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        System.out.println(dp(wt, val, 3, 4));
    }
}
