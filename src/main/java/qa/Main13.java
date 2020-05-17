package qa;

import java.util.Scanner;

/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * @author chujunjie
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line = sc.nextLine();
        String[] split = line.split(" ");
        for (int i = split.length -1 ; i >= 0 ; i--) {
            sb.append(split[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
        sc.close();
    }
}
