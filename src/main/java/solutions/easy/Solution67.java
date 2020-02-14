package solutions.easy;

/**
 * @Description: 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * @Author: chujunjie
 * @Date: Create in 20:05 2020/1/31
 * @Modified By
 */
public class Solution67 {

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        int carry = 0;
        while (ia >= 0 || ib >= 0 || carry > 0) {
            carry += (ia >= 0) ? a.charAt(ia--) - '0' : 0;
            carry += (ib >= 0) ? b.charAt(ib--) - '0' : 0;
            res.append(carry & 1);
            carry = carry >> 1;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
