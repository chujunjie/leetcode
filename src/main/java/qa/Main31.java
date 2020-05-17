package qa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1、对输入的字符串进行加解密，并输出。
 * <p>
 * 2加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * <p>
 * 3、解密方法为加密的逆过程。
 *
 * @author chujunjie
 */
public class Main31 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String str1 = encrypt(str);
            System.out.println(str1);
            str = bf.readLine();
            String str2 = decrypt(str);
            System.out.println(str2);
        }
    }

    /**
     * 加密
     *
     * @param line line
     * @return String
     */
    private static String encrypt(String line) {
        char[] cha = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cha) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'z') {
                    sb.append('A');
                } else {
                    sb.append((char) (c + 1 - 32));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z') {
                    sb.append('a');
                } else {
                    sb.append((char) (c + 32 + 1));
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '9') {
                    sb.append('0');
                } else {
                    sb.append(c - 48 + 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 解码
     *
     * @param line line
     * @return String
     */
    private static String decrypt(String line) {
        char[] cha = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cha) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a') {
                    sb.append('Z');
                } else {
                    sb.append((char) (c - 1 - 32));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'A') {
                    sb.append('z');
                } else {
                    sb.append((char) (c + 32 - 1));
                }
            } else if (c >= '0' && c <= '9') {
                if (c == '0') {
                    sb.append('9');
                } else {
                    sb.append(c - 48 - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
