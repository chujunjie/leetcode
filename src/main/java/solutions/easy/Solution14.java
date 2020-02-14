package solutions.easy;

/**
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author: chujunjie
 * @Date: Create in 18:15 2020/1/27
 * @Modified By
 */
public class Solution14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length <= 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String val = longestCommonPrefix(strs[0], strs[1]);
            for (int i = 2; i < strs.length; i++) {
                val = longestCommonPrefix(val, strs[i]);
            }
            return val;
        }
    }

    private static String longestCommonPrefix(String s1, String s2) {
        if (s1.length() <= s2.length()) {
            if (s2.startsWith(s1)) {
                return s1;
            } else {
                if (s1.length() == 1) {
                    return "";
                } else {
                    return longestCommonPrefix(s1.substring(0, s1.length() - 1), s2);
                }
            }
        } else {
            return longestCommonPrefix(s2, s1);
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix2(strs));
    }
}
