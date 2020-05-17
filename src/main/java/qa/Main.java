package qa;

import java.util.Scanner;

/**
 * 换汽水
 *
 * @author chujunjie
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 空汽水瓶数
            int n = sc.nextInt();
            // 能喝汽水瓶数
            int count = 0;
            if (n > 0) {
                while (n > 1) {
                    count += n / 3;
                    n = n % 3 + n / 3;
                    if (n == 2) {
                        n++;
                    }
                }
                System.out.println(count);
            } else if (n == 0) {
                break;
            }
        }
        sc.close();
    }
}
