package solutions.easy;

/**
 * @Description: 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * @Author: chujunjie
 * @Date: Create in 16:51 2020/1/28
 * @Modified By
 */
public class Solution28 {

    /**
     * 暴力回溯
     *
     * @param haystack haystack
     * @param needle   needle
     * @return int
     */
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int head = -1;
        char[] needles = needle.toCharArray();
        boolean exist = false;
        for (int i = 0; i < haystack.length() && !exist && haystack.length() - i >= needles.length; i++) {
            for (int j = i; j < i + needles.length; j++) {
                if (haystack.charAt(j) != needles[j - i]) {
                    break;
                }
                if (j == i + needles.length - 1) {
                    head = i;
                    exist = true;
                    break;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaa", "aaaa"));
    }
}
