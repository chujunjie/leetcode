package solutions.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author: chujunjie
 * @Date: Create in 15:05 2020/2/7
 * @Modified By
 */
public class Solution169 {

    /**
     * 哈希表
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int n = length >>> 1;
        for (int i = 0; i < length; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            if (++count <= n) {
                map.put(nums[i], count);
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Boyer-Moore 投票算法
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = -1;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        System.out.println(majorityElement2(nums));
    }
}
