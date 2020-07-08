package solutions.medium;

/**
 * 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * @author chujunjie
 * @date Create in 21:43 2020/7/8
 */
public class Solution402 {

    private static final char ZERO = '0';

    /**
     * 单调栈
     *
     * @param num num
     * @param k   k
     * @return String
     */
    public static String removeKDigits(String num, int k) {
        char[] a = num.toCharArray();
        char[] stack = new char[a.length];
        // 栈的高度
        int size = 0;
        // 被删除的数的个数
        int deleted = 0;
        int i;

        for (i = 0; i < a.length; i++) {
            while (size > 0 && stack[size - 1] > a[i] && deleted < k) {
                size--;
                deleted++;
            }
            if (deleted >= k) {
                break;
            }
            stack[size++] = a[i];
        }

        // 输出
        StringBuilder out = new StringBuilder();
        for (int j = 0; j < size && j < a.length - k; j++) {
            if (stack[j] != ZERO) {
                out.append(stack[j]);
            }
        }
        if (size == 0 || stack[size - 1] == ZERO) {
            while (i < a.length && a[i] == ZERO) {
                i++;
            }
        }
        out.append(num.substring(i));
        if (out.length() == 0) {
            out.append(ZERO);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("10200", 1));
    }
}
