package solutions.easy;

/**
 * @Description: 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * @Author: chujunjie
 * @Date: Create in 12:34 2020/2/10
 * @Modified By
 */
public class Solution172 {

    /**
     * 含有 2 的因子每两个出现一次，含有 5 的因子每 5 个出现一次，所有 2 出现的个数远远多于 5，
     * 换言之找到一个 5，一定能找到一个 2 与之配对。所以我们只需要找有多少个 5。
     * 5 的个数就是 n / 5 + n / 25 + n / 125 ...
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }
}
