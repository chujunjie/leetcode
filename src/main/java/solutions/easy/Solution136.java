package solutions.easy;

/**
 * @Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @Author: chujunjie
 * @Date: Create in 17:21 2020/2/6
 * @Modified By
 */
public class Solution136 {

    public static int singleNumber(int[] nums) {
        int result = 0;
        // XOR 满足交换律和结合律
        // a ⊕ b ⊕ a = (a ⊕ a) ⊕ b = 0 ⊕ b = b
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
