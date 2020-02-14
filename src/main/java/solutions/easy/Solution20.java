package solutions.easy;

import java.util.Stack;

/**
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @Author: chujunjie
 * @Date: Create in 14:35 2020/1/28
 * @Modified By
 */
public class Solution20 {

    private static final char a = '(';
    private static final char b = '{';
    private static final char c = '[';

    private static final char d = ')';
    private static final char e = '}';
    private static final char f = ']';

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == a || chr == b || chr == c) {
                stack.push(getAdverse(chr));
            } else if (stack.size() == 0 || chr != stack.pop()) {
                return false;
            }
        }
        return stack.size() == 0;
    }

    public static boolean isValid2(String s) {
        char[] chrArr = new char[s.length() + 1];
        // 数组尾指针
        int tail = 1;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == a || chr == b || chr == c) {
                chrArr[tail++] = getAdverse(chr);
            } else if (chrArr[--tail] != chr) {
                return false;
            }
        }
        return tail == 1;
    }

    private static char getAdverse(char chr) {
        switch (chr) {
            case a:
                return d;
            case b:
                return e;
            case c:
                return f;
            default:
                return '1';
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid1("([)]"));
        System.out.println(isValid2("([])"));
    }
}
