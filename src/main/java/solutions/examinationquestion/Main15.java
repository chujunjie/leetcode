package solutions.examinationquestion;

import java.util.Scanner;

/**
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * @author chujunjie
 */
public class Main15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int count = 0;
        while (num != 0) {
            count++;
            num &= num - 1;
        }
        System.out.println(count);
        sc.close();
    }
}
