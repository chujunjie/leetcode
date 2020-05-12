package solutions.dp;

import java.util.Arrays;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * @author chujunjie
 * @date Create in 20:37 下午 2020/5/12
 * @modified by
 */
public class Solution45 {

    private static int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
            if (end == length) {
                break;
            }
        }
        return steps;
    }

    private static int[] MEMO;

    private static int jump(int[] nums) {
        MEMO = new int[nums.length];
        Arrays.fill(MEMO, nums.length);
        return dp(nums, 0);
    }

    /**
     * 从索引P到最后一格所需最少步数
     *
     * @param nums nums
     * @param p    p
     * @return int
     */
    private static int dp(int[] nums, int p) {
        int length = nums.length;

        if (p + 1 >= length) {
            return 0;
        }

        if (MEMO[p] != length) {
            return MEMO[p];
        }

        int steps = nums[p];
        for (int i = 1; i <= steps; i++) {
            MEMO[p] = Math.min(MEMO[p], dp(nums, p + i) + 1);
        }
        return MEMO[p];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
        System.out.println(jump2(nums));
    }
}
