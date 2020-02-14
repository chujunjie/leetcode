package solutions.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个整数数组 nums 和一个目标值 target，
 * 在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * @Author: chujunjie
 * @Date: Create in 17:13 2020/1/27
 * @Modified By
 */
public class Solution1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
