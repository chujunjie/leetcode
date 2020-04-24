package solutions.dp;

import java.util.Arrays;

/**
 * @Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @Author: chujunjie
 * @Date: Create in 17:13 2020/4/26
 * @Modified By
 */
public class Solution300 {

    /**
     * DP 时间复杂度O(N^2)
     *
     * @param nums nums
     * @return int
     */
    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return Arrays.stream(dp).max().orElse(1);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
