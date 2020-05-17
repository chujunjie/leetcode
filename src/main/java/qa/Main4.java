package qa;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * @author chujunjie
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] s = line.split("\\s+");
        System.out.println(s[s.length - 1].length());
        sc.close();
    }
}
