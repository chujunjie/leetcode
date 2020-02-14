package solutions.easy;

/**
 * @Description: 罗马数字转整数
 * @Author: chujunjie
 * @Date: Create in 18:00 2020/1/27
 * @Modified By
 */
public class Solution13 {

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static int romanToInt(String s) {
        int rev = 0;
        int current = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int next = getValue(s.charAt(i));
            if (current > next) {
                rev += current;
            } else {
                rev -= current;
            }
            current = next;
        }
        rev += current;
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
