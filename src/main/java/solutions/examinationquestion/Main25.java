package solutions.examinationquestion;

import java.util.Scanner;

/**
 * 最小公倍数
 *
 * @author chujunjie
 */
public class Main25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println((n * m) / calculate(m, n));
        }
    }

    /**
     * 求最大公约数
     *
     * @param m m
     * @param n n
     * @return int
     */
    private static int calculate(int m, int n) {
        int temp;
        while (n != 0) {
            temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
}
