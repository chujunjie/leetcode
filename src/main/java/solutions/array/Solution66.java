package solutions.array;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author chujunjie
 * @date Create in 19:24 2020/1/31
 */
public class Solution66 {

    public static int[] plusOne(int[] digits) {
        int b = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + b >= 10) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + b;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 9, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
}
