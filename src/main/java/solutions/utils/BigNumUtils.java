package solutions.utils;

/**
 * 大数运算
 *
 * @author chujunjie
 * @date Create in 21:00 2020/7/8
 */
public class BigNumUtils {

    private static final char ZERO = '0';
    private static final String ZERO_STR = "0";

    /**
     * 大数加法
     *
     * @param str1 str1
     * @param str2 str2
     * @return String
     */
    public static String add(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int n1 = s1.length, n2 = s2.length;
        int maxL = Math.max(n1, n2);

        // +1防止溢出
        int[] a = new int[maxL + 1];
        int[] b = new int[maxL + 1];
        for (int i = 0; i < n1; i++) {
            a[i] = s1[n1 - i - 1] - ZERO;
        }
        for (int i = 0; i < n2; i++) {
            b[i] = s2[n2 - i - 1] - ZERO;
        }
        for (int i = 0; i < maxL; i++) {
            if (a[i] + b[i] >= 10) {
                int tmp = a[i] + b[i];
                a[i] = tmp % 10;
                a[i + 1] += tmp / 10;
            } else {
                a[i] += b[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        if (a[maxL] != 0) {
            sb.append((char) (a[maxL] + ZERO));
        }
        for (int i = maxL - 1; i >= 0; i--) {
            sb.append((char) (a[i] + ZERO));
        }
        return sb.toString();
    }

    /**
     * 大数乘法
     *
     * @param num1 num1
     * @param num2 num2
     * @return String
     */
    public static String mul(String num1, String num2) {
        if (ZERO_STR.equals(num1) || ZERO_STR.equals(num2)) {
            return ZERO_STR;
        }
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        int n1 = s1.length, n2 = s2.length;
        int[] a = new int[n1];
        int[] b = new int[n2];
        int[] c = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            a[i] = s1[n1 - i - 1] - ZERO;
        }
        for (int i = 0; i < n2; i++) {
            b[i] = s2[n2 - i - 1] - ZERO;
        }

        // 竖乘
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                c[i + j] += a[i] * b[j];
            }
        }

        // 进位
        for (int i = 0; i < n1 + n2 - 1; i++) {
            if (c[i] >= 10) {
                c[i + 1] += c[i] / 10;
                c[i] %= 10;
            }
        }

        // 找到第一个不为0的元素，即为结果集的首位
        int i;
        for (i = n1 + n2 - 1; i >= 0; i--) {
            if (c[i] != 0) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (; i >= 0; i--) {
            sb.append((char) (c[i] + ZERO));
        }
        return sb.toString();
    }

    /**
     * 大数阶乘
     *
     * @param n n
     * @return String
     */
    public static String factorial(int n) {
        int[] res = new int[100001];
        int digit = 1;
        res[0] = 1;
        for (int i = 2; i <= n; i++) {
            int carry = 0;
            for (int j = 0; j < digit; j++) {
                // 每一位的运算结果
                int temp = res[j] * i + carry;
                // 将最低位保留在原位置
                res[j] = temp % 10;
                // 计算进位, 等下这个进位会累加到j+1
                carry = temp / 10;
            }
            while (carry != 0) {
                res[digit] = carry % 10;
                carry /= 10;
                digit++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = digit - 1; i >= 0; i--) {
            sb.append((char) (res[i] + ZERO));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "112233445566778899";
        String b = "998877665544332211";
        System.out.println(add(a, b));
        System.out.println(mul(a, b));
        System.out.println(factorial(5));
    }
}
