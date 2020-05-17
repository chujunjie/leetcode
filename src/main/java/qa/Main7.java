package qa;

import java.util.Scanner;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 *
 * @author chujunjie
 */
public class Main7 {

    public static String getResult(long ulDataInput) {
        StringBuilder str = new StringBuilder();
        int index = 2;
        while (index <= ulDataInput) {
            if (ulDataInput % index == 0) {
                if (index == ulDataInput) {
                    str.append(index).append(" ");
                    break;
                } else {
                    str.append(index).append(" ");
                    ulDataInput = ulDataInput / index;
                }
            } else {
                index++;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long params = sc.nextLong();
        if (params < 2) {
            sc.close();
            return;
        }
        String result = getResult(params);
        System.out.println(result);
        sc.close();
    }
}
