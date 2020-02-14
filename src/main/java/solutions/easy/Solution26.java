package solutions.easy;

import java.util.Arrays;

/**
 * @Description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @Author: chujunjie
 * @Date: Create in 16:10 2020/1/28
 * @Modified By
 */
public class Solution26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
//        int index = 1;
//        int prev = nums[0];
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[cur]) {
                nums[++cur] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return ++cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
