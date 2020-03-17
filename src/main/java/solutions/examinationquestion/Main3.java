package solutions.examinationquestion;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * @author chujunjie
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hexTable = "0123456789ABCDEF";
        while (sc.hasNext()) {
            String hexNum = sc.next().substring(2).toUpperCase();
            int num = 0;
            for (int j = 0, i = hexNum.length() - 1; i >= 0; i--, j++) {
                num += hexTable.indexOf(hexNum.charAt(j)) * (int) Math.pow(16, i);
            }
            System.out.println(num);
        }
    }
}
