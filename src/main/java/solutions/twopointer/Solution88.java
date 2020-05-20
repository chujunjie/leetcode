package solutions.twopointer;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @author chujunjie
 * @date Create in 20:02 2020/2/2
 * @modified by
 */
public class Solution88 {

    /**
     * 双指针 从后往前 空间复杂度O(1)
     *
     * @param nums1 nums1
     * @param m     m
     * @param nums2 nums2
     * @param n     n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int p = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[p--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

    /**
     * 双指针 从前往后 空间复杂度O(m + n)
     *
     * @param nums1 nums1
     * @param m     m
     * @param nums2 nums2
     * @param n     n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, p = 0;
        while (i <= m - 1 && j <= n - 1) {
            if (nums1[i] <= nums2[j]) {
                res[p++] = nums1[i++];
            } else {
                res[p++] = nums2[j++];
            }
        }
        while (i <= m - 1) {
            res[p++] = nums1[i++];
        }
        while (j <= n - 1) {
            res[p++] = nums2[j++];
        }
        System.arraycopy(res, 0, nums1, 0, res.length);
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge1(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));

        int[] num3 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num4 = new int[]{2, 5, 6};
        merge2(num3, 3, num4, 3);
        System.out.println(Arrays.toString(num3));
    }
}
