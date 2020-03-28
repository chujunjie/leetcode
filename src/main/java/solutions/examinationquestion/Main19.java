package solutions.examinationquestion;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），
 * 对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 *
 * @author chujunjie
 */
public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String str = sc.next();
            int lineNum = sc.nextInt();
            String[] arr = str.split("\\\\");
            String s = arr[arr.length - 1];
            if (s.length() > 16) {
                s = s.substring(s.length() - 16);
            }
            String key = s + " " + lineNum;
            int value = 1;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, value);
            }
        }
        int count = 0;
        for (String string : map.keySet()) {
            count++;
            if (count > (map.keySet().size() - 8)) {
                System.out.println(string + " " + map.get(string));
            }
        }
    }
}
