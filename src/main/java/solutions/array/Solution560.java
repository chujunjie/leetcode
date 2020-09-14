package solutions.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * @author chujunjie
 * @date Create in 19:38 2020/9/14
 */
public class Solution560 {

    /**
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     *
     * @param nums nums
     * @param k    k
     * @return int
     */
    public static int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] preNums = new int[length + 1];

        for (int i = 1; i <= nums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }

        int res = 0;
        for (int i = 0; i < preNums.length; i++) {
            for (int j = i + 1; j < preNums.length; j++) {
                if (preNums[j] - preNums[i] == k) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 优化 备忘录思想
     *
     * @param nums nums
     * @param k    k
     * @return int
     */
    public static int subarraySum2(int[] nums, int k) {
        // map：前缀和 -> 该前缀和出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);

        int ans = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            // 这是我们想找的前缀和 nums[0..j]
            int target = sum - k;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(target)) {
                ans += preSum.get(target);
            }
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum2(new int[]{1, 1, 1}, 2));
    }
}
