package solutions.easy;

/**
 * @Description: 假设正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次可以爬 1 或 2 个台阶。有多少种不同的方法可以爬到楼顶呢？
 * @Author: chujunjie
 * @Date: Create in 17:52 2020/2/2
 * @Modified By
 */
public class Solution70 {

    /**
     * 斐波那契数列公式
     *
     * @param n n
     * @return int
     */
    public static int climbStairs3(int n) {
        double sqrt5 = Math.sqrt(5);
        double fib = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) (fib / sqrt5);
    }

    /**
     * 动态规划
     *
     * @param n n
     * @return int
     */
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

    /**
     * 暴力递归
     *
     * @param n n
     * @return int
     */
    public static int climbStairs1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(45));
    }
}
