package solutions.easy;

/**
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Author: chujunjie
 * @Date: Create in 18:25 2020/1/28
 * @Modified By
 */
public class Solution53 {

    /**
     * 动态规划
     *
     * @param nums nums
     * @return int
     */
    public static int maxSubArray3(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    /**
     * 贪心算法
     *
     * @param nums nums
     * @return int
     */
    public static int maxSubArray2(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * 分治
     *
     * @param nums nums
     * @return int
     */
    public static int maxSubArray1(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >> 1;
        int leftSum = helper(nums, 0, mid);
        int rightSum = helper(nums, mid + 1, right);
        int crossSum = crossSum(nums, left, right, mid);
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private static int crossSum(int[] nums, int left, int right, int mid) {
        if (left == right) {
            return nums[left];
        }
        int leftSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = mid; i > left - 1; --i) {
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }
        int rightSum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = mid + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSum = Math.max(rightSum, currSum);
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }
}
