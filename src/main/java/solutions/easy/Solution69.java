package solutions.easy;

/**
 * @Description: 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @Author: chujunjie
 * @Date: Create in 20:30 2020/1/31
 * @Modified By
 */
public class Solution69 {

    /**
     * 牛顿迭代法
     *
     * @param x x
     * @return int
     */
    public static int mySqrt2(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }

    /**
     * 二分法
     *
     * @param x x
     * @return int
     */
    public static int mySqrt1(int x) {
        long left = 0;
        long right = (x >> 1) + 1;
        while (left < right) {
            // 取右中位数
            long mid = (left + right + 1) >> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(2147395599));
    }
}
