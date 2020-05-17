package qa;

import java.util.Scanner;

/**
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 * 如：输入“I am a student”，输出“tneduts a ma I”。
 *
 * @author chujunjie
 */
public class Main28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line = sc.nextLine();
        for (int i = line.length() - 1; i >= 0; i--) {
            sb.append(line.charAt(i));
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
