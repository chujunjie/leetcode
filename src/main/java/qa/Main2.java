package qa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 明明的随机数
 *
 * @author chujunjie
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            // 第一个数字或者该数字不等于前一个数字 都可以输出
            for (int i = 0; i < n; i++) {
                if (i == 0 || arr[i] != arr[i - 1]) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
