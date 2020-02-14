package solutions.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * @Author: chujunjie
 * @Date: Create in 12:34 2020/2/7
 * @Modified By
 */
public class Solution167 {

    /**
     * 双指针，由于题目给出的是排序数组
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else if (numbers[head] + numbers[tail] < target) {
                head++;
            } else {
                return new int[]{++head, ++tail};
            }
        }
        return null;
    }

    /**
     * 滑动窗口
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i + 1};
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum1(nums, 9)));
    }
}
