package solutions.examinationquestion;

import java.util.Scanner;

/**
 * 编写一个函数，计算字符串中含有的不同字符的个数。
 * 字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 *
 * @author chujunjie
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] arr = new int[128];
        for (int i = 0; i < line.length(); i++) {
            arr[line.charAt(i)]++;
        }
        int res = 0;
        for (int i : arr) {
            if (i != 0) {
                res++;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
