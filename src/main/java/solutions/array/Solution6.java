package solutions.array;

import java.util.Arrays;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * @author chujunjie
 * @date Create in 1:57 2020/8/25
 */
public class Solution6 {

    /**
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 输出: "LCIRETOESIIGEDHN"
     *
     * @param s       s
     * @param numRows numRows
     * @return String
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        int period = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 在周期中的位置
            int index = i % period;
            if (index < numRows) {
                arr[index] += c;
            } else {
                arr[period - index] += c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }
}
