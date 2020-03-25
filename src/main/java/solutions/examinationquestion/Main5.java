package solutions.examinationquestion;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * @author chujunjie
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String aim = sc.nextLine();
        String[] split = str.split("");
        int count = 0;
        for (String s : split) {
            if (s.equals(aim)) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
