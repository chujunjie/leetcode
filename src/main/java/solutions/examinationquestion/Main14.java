package solutions.examinationquestion;

import java.util.*;

/**
 * 给定n个字符串，请对n个字符串按照字典序排列。
 *
 * @author chujunjie
 */
public class Main14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            list.add(sc.nextLine());
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }

//    /**
//     * 去重
//     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Set<String> set = new TreeSet<>((a, b) -> {
//            for (int i = 0; i < a.length() && i < b.length(); i++) {
//                if (a.charAt(i) == b.charAt(i)) {
//                    continue;
//                }
//                return a.charAt(i) - b.charAt(i);
//            }
//            return a.length() - b.length();
//        });
//        int count = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < count; i++) {
//            set.add(sc.nextLine());
//        }
//        set.forEach(System.out::println);
//    }
}
