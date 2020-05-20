package solutions.twopointer;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * @author chujunjie
 * @date Create in 21:07 2020/5/20
 * @modified
 */
public class Solution167 {

    private static int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;

        while (head < tail) {
            if (numbers[head] + numbers[tail] == target) {
                return new int[]{++head, ++tail};
            } else if (numbers[head] + numbers[tail] < target) {
                head++;
            } else {
                tail--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
