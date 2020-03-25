package solutions.examinationquestion;

import java.util.Scanner;

/**
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * @author chujunjie
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            while (line.length() >= 8) {
                System.out.println(line.substring(0, 8));
                line = line.substring(8);
            }
            if (line.length() > 0) {
                line = line + "00000000";
                System.out.println(line.substring(0, 8));
            }
        }
        sc.close();
    }
}
