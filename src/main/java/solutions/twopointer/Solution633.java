package solutions.twopointer;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * @author chujunjie
 * @date Create in 9:39 下午 2020/5/20
 * @modified by
 */
public class Solution633 {

    private static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }

        int head = 0;
        int tail = (int) Math.sqrt(c);

        while (head <= tail) {
            // 防止溢出
            int res = c - head * head;
            int res2 = tail * tail;
            if (res == res2) {
                return true;
            } else if (res > res2) {
                head++;
            } else {
                tail--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }
}
