package solutions.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序
 * 用于大量数，很长的数进行排序时。
 * 将所有的数的个位数取出，按照个位数进行排序，构成一个序列。
 * 将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列。
 *
 * @author chujunjie
 * @date Create in 23:12 2020/7/7
 */
public class BaseSort {

    private static void baseSort(int[] a) {
        // 首先确定排序的趟数
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        int time = 0;
        // 判断位数
        while (max > 0) {
            max /= 10;
            time++;
        }
        // 建立10个队列
        List<ArrayList<Integer>> queue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            queue.add(list);
        }
        // 进行time次分配和收集
        for (int i = 0; i < time; i++) {
            // 分配数组元素
            for (int value : a) {
                // 得到数字的第time+1位数
                int x = value % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(value);
                queue.set(x, queue2);
            }
            // 元素计数器
            int count = 0;
            // 收集队列元素
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    a[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {16, 8, 7, 50, 1, 26};
        baseSort(a);
        System.out.println(Arrays.toString(a));
    }
}
