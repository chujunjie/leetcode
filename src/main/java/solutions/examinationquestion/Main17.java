package solutions.examinationquestion;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 *
 * @author chujunjie
 */
public class Main17 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int x = 0;
            int y = 0;
            String[] tokens = scan.nextLine().split(";");
            for (String token : tokens) {
                try {
                    int b = Integer.parseInt(token.substring(1, token.length()));
                    if (token.charAt(0) == 'A') {
                        x -= b;
                    }
                    if (token.charAt(0) == 'W') {
                        y += b;
                    }
                    if (token.charAt(0) == 'S') {
                        y -= b;
                    }
                    if (token.charAt(0) == 'D') {
                        x += b;
                    }
                } catch (Exception e) {
                    // do nothing
                }
            }
            System.out.println(x + "," + y);
        }
    }

//    private static final Pattern PATTERN = Pattern.compile("[0-9]*");
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int i = 0;
//        int j = 0;
//        String[] split = sc.nextLine().split(";");
//        for (String str : split) {
//            if (str.isEmpty() || str.length() < 2) {
//                continue;
//            }
//            String s1 = str.substring(0, 1);
//            String s2 = str.substring(1);
//            if (!PATTERN.matcher(s2).matches()) {
//                continue;
//            }
//            int move = Integer.parseInt(s2);
//            switch (s1) {
//                case "A":
//                    i -= move;
//                    break;
//                case "W":
//                    j += move;
//                    break;
//                case "S":
//                    j -= move;
//                    break;
//                case "D":
//                    i += move;
//                    break;
//                default:
//                    break;
//            }
//        }
//        System.out.println(i + "," + j);
//        sc.close();
//    }
}
