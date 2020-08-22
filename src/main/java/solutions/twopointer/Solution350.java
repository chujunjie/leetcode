package solutions.twopointer;

import java.util.Arrays;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author chujunjie
 * @date Create in 11:39 2020/8/22
 */
public class Solution350 {

    /**
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     *
     * @param nums1 nums1
     * @param nums2 nums2
     * @return int[]
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int[] res = new int[Math.min(nums1.length, nums2.length)];

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                res[index++] = nums1[index1++];
                index2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
