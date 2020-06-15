package solutions.utils;

import java.util.Arrays;

/**
 * @author chujunjie
 * @date Create in 21:23 2020/6/15
 */
public class Util {

    /**
     * 判断奇偶
     *
     * @param n n
     * @return true: 偶数  false: 奇数
     */
    public static boolean judgeParity(int n) {
        return (n & 1) == 0;
    }

    /**
     * 判断是否为2的幂次方
     *
     * @param n n
     * @return true: 是  false: 否
     */
    public static boolean judgePowerOf2(int n) {
        return (n & n - 1) == 0;
    }

    /**
     * 找出不大于N的最大的2的幂指数
     *
     * @param n n
     * @return int
     */
    public static int findN(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n + 1) >> 1;
    }

    /**
     * 找出不重复的数
     *
     * @param nums nums
     * @return int
     */
    public static int findUniqueNum(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
        System.out.println(judgeParity(5));
        System.out.println(judgePowerOf2(16));
        System.out.println(findN(19));
        System.out.println(findUniqueNum(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4}));
    }
}
