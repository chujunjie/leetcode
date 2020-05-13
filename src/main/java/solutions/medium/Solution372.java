package solutions.medium;

import java.util.Arrays;

/**
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * @author chujunjie
 * @date Create in 22:50 2020/5/13
 * @modified By
 */
public class Solution372 {

    private static int superPow2(int a, int[] b) {
        int numB = b[0];
        a = a % 1337;
        if (a == 0) {
            return 0;
        }
        for (int i = 1; i < b.length; i++) {
            // 借助欧拉公式算出作为模底的1337有多少个小于它与之互质的正整数，即求出φ（1337）=1140
            numB = (numB * 10 + b[i]) % 1140;
        }
        numB += 1140;
        int x = a;
        for (int j = 0; j < numB; j++) {
            x = x % 1337;
            x *= a;
        }
        x /= a;
        return x;
    }

    private static int superPow(int a, int[] b) {
        return recursive(a, b) % 1337;
    }

    public static int recursive(int a, int[] b) {
        if (b.length == 0) {
            return 1;
        }
        int i = b[b.length - 1];
        int[] cp = Arrays.copyOf(b, b.length - 1);

        // 溢出
        return (int) (Math.pow(superPow(a, cp), 10) * Math.pow(a, i));
    }

    public static void main(String[] args) {
        int a = 2;
        int[] nums = new int[]{1, 0};
        System.out.println(superPow(a, nums));
        System.out.println(superPow2(a, nums));
    }
}
