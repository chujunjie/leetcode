package solutions.easy;

/**
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Author: chujunjie
 * @Date: Create in 17:53 2020/1/27
 * @Modified By
 */
public class Solution9 {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == x || rev / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
