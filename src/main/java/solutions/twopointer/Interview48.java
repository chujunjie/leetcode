package solutions.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * @author chujunjie
 * @date Create in 22:14 2020/5/25
 * @modified by
 */
public class Interview48 {

    /**
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s s
     * @return int
     */
    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                // 更新左指针 i
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            res = Math.max(res, j - i);
            dic.put(s.charAt(j), j);

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
