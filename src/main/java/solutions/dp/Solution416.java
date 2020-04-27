package solutions.dp;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @author chujunjie
 * @date Create in 10:18 下午 2020/4/27
 * @modified by
 */
public class Solution416 {

    /**
     * 状态：【可选择的元素】和【子集容量】
     * 选择：【是否放进子集】
     * base case: dp[..][0] = true;
     *
     * @param nums nums
     * @return 能否分割为等和子集
     */
    private static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) != 0) {
            return false;
        }

        sum = sum >>> 1;
        int length = nums.length;

        // 前i个元素，当前容量为j时，是否能分割为等和子集
        boolean[][] dp = new boolean[length + 1][sum + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[length][sum];
    }

    /**
     * 压缩dp数组
     *
     * @param nums nums
     * @return boolean
     */
    private static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) != 0) {
            return false;
        }

        int weight = sum >>> 1;

        boolean[] dp = new boolean[weight + 1];
        dp[0] = true;

        for (int n : nums) {
            for (int j = weight; j >= 1; j--) {
                if (j - n >= 0) {
                    dp[j] = dp[j] | dp[j - n];
                }
            }
        }
        return dp[weight];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition2(nums));
    }
}
