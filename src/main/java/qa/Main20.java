package qa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 *
 * @author chujunjie
 */
public class Main20 {

    private static final String OK = "OK";
    private static final String NG = "NG";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() < 9) {
                list.add(NG);
                continue;
            }
            int[] cla = {0, 0, 0, 0};
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    cla[0] = 1;
                } else if (ch >= 'a' && ch <= 'z') {
                    cla[1] = 1;
                } else if (ch >= 'A' && ch <= 'Z') {
                    cla[2] = 1;
                } else {
                    cla[3] = 1;
                }
            }
            if (cla[0] + cla[1] + cla[2] + cla[3] < 3) {
                list.add(NG);
                continue;
            }

            boolean isExist = false;
            for (int i = 0; i < s.length() - 3; i++) {
                String str1 = s.substring(i, i + 3);
                String str2 = s.substring(i + 3);
                if (str2.contains(str1)) {
                    isExist = true;
                    break;
                }
            }
            list.add(isExist ? NG : OK);
        }
        list.forEach(System.out::println);
    }
}
