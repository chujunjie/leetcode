package solutions.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * @Author: chujunjie
 * @Date: Create in 17:13 2020/4/4
 * @Modified By
 */
public class Solution93 {

    private static final char ZERO = '0';

    public static void main(String[] args) {
        System.out.println(getIps("25525511234"));
        System.out.println(getIps("123456789"));
    }

    private static List<String> getIps(String str) {
        List<String> res = new ArrayList<>();
        if (str.length() < 4 || str.length() > 12) {
            return res;
        }
        backtrack(res, str, "", 0);
        return res;
    }

    private static void backtrack(List<String> res, String remain, String current, int count) {
        if (count == 4 && remain.length() == 0) {
            res.add(current.substring(1));
            return;
        }
        // 只有一个条件达成，直接跳出
        if (count == 4 || remain.length() == 0) {
            return;
        }
        backtrack(res, remain.substring(1), current + "." + remain.substring(0, 1), count + 1);
        if (remain.charAt(0) != ZERO && remain.length() > 1) {
            backtrack(res, remain.substring(2), current + "." + remain.substring(0, 2), count + 1);
        }
        if (remain.charAt(0) != ZERO && remain.length() > 2 && Integer.parseInt(remain.substring(0, 3)) <= 255) {
            backtrack(res, remain.substring(3), current + "." + remain.substring(0, 3), count + 1);
        }
    }
}
