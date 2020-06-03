package solutions.dp;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * @author chujunjie
 * @date Create in 21:39 2020/6/3
 */
public class Solution312 {

    /**
     * 输入: [3,1,5,8]
     * 输出: 167
     * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     *
     * @param nums nums
     * @return int
     */
    private static int maxCoins(int[] nums) {
        int length = nums.length;

        // 添加两侧的虚拟气球
        int[] balloon = new int[length + 2];
        System.arraycopy(nums, 0, balloon, 1, length);
        balloon[0] = 1;
        balloon[length + 1] = 1;

        // dp数组，对于戳破气球i和气球j之间（开区间）的所有气球，所能获取的最高分
        int[][] dp = new int[length + 2][length + 2];

        /*
         * i 和 j 就是两个「状态」，最后戳破的那个气球 k 就是「选择」
         * base case: i = j, dp[i][j] = 0;
         *
         * 遍历方式：
         * 1.斜着遍历（参考博弈问题）
         * 2.从下往上，从左到右
         */
        for (int i = length; i >= 0; i--) {
            for (int j = i + 1; j <= length + 1; j++) {
                // 穷举最后戳破的气球，求得当前情形下的最高得分
                for (int k = i + 1; k < j; k++) {
                    /*
                     * 最后戳破气球k，需要先后戳破开区间(i, k)和(k, j)
                     * 由于戳破气球获得的分数只与两侧气球相关，所以分开计算(i, k)和(k, j)不会对整体造成影响
                     */
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + balloon[i] * balloon[j] * balloon[k]);
                }
            }
        }

        return dp[0][length + 1];
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }
}
