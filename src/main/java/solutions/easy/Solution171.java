package solutions.easy;

/**
 * @Description: 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * @Author: chujunjie
 * @Date: Create in 18:53 2020/2/7
 * @Modified By
 */
public class Solution171 {

    public static int titleToNumber(String s) {
        int total = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            total += (s.charAt(i) - 'A' + 1) * Math.pow(26, length - 1 - i);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
}
