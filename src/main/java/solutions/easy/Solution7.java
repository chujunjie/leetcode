package solutions.easy;

/**
 * @Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @Author: chujunjie
 * @Date: Create in 17:42 2020/1/27
 * @Modified By
 */
public class Solution7 {

    public static int reverse(int x) {
        int rev = 0;
        int a = Integer.MAX_VALUE / 10;
        int b = Integer.MAX_VALUE % 10;
        int c = Integer.MIN_VALUE / 10;
        int d = Integer.MIN_VALUE % 10;

        while (x != 0) {
            int remainder = x % 10;
            x /= 10;
            if (rev > a || (rev == a && remainder > b)) {
                return 0;
            }
            if (rev < c || (rev == c && remainder < d)) {
                return 0;
            }
            rev = rev * 10 + remainder;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123456790));
    }
}
