package solutions.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author chujunjie
 * @date Create in 16:39 2020/1/28
 */
public class Solution27 {

    public static int removeElement(int[] nums, int val) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
    }
}
