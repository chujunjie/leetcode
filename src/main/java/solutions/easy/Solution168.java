package solutions.easy;

/**
 * @Description: 给定一个正整数，返回它在 Excel 表中相对应的列名称
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * @Author: chujunjie
 * @Date: Create in 13:47 2020/2/7
 * @Modified By
 */
public class Solution168 {

    public static String convertToTitle(int n) {
        if (n <= 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int c = n % 26;
            if (c == 0) {
                c = 26;
                n -= 1;
            }
            sb.insert(0, (char) ('A' + c - 1));
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
}
