package solutions.examinationquestion;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * @author chujunjie
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortedMap<Integer, Integer> map = new TreeMap<>();
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String[] split = sc.nextLine().split("\\s+");
            int index = Integer.parseInt(split[0]);
            int value = Integer.parseInt(split[1]);
            if (map.containsKey(index)) {
                map.put(index, map.get(index) + value);
            } else {
                map.put(index, value);
            }
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
        sc.close();
    }
}
