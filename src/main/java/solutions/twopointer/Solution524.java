package solutions.twopointer;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * @author chujunjie
 * @date Create in 23:48 2020/5/22
 * @modified By
 */
public class Solution524 {

    /**
     * Input:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     * <p>
     * Output:
     * "apple"
     *
     * @param s s
     * @param d d
     * @return String
     */
    private static String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String target : d) {
            int length1 = res.length();
            int length2 = target.length();
            if (length1 > length2 || (length1 == length2 && res.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                res = target;
            }
        }
        return res;
    }

    private static boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}
