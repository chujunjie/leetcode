package solutions.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序工具类
 *
 * @author chujunjie
 * @date Create in 23:17 2020/7/7
 */
public class SortUtils {

    /**
     * 桶排序
     * @param arr arr
     */
    private static void bucketSort(int[] arr) {

        // 寻找数组中min，max，用于建桶
        int min = 0, max = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        // 开始建桶，注意桶的数量等于max - min + 1
        int bucketCount = max - min + 1;
        int[] bucket = new int[bucketCount];
        for (int i = 0; i <= arr.length - 1; i++)
            bucket[arr[i] - min]++;

        for (int i = 1; i < bucketCount; i++)
            bucket[i] = bucket[i] + bucket[i - 1];

        // 开始排序
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);

        // 从后往前排序，保持元素相对位置，保证算法稳定性。
        for (int i = arr.length - 1; i >= 0; i--) {
            //桶中i位置元素值即为落入桶i中数组元素在排序后的序列中的下标值
            int j = --bucket[copy[i] - min];
            arr[j] = copy[i];
        }

        // 若从前往后排序，虽然排序结果相同，但会破坏元素相对位置和算法稳定性
//		for(int i = 0; i <= arr.length - 1; i++){
//			arr[--bucket[copy[i] - min]] = copy[i];
//		}
    }

    /**
     * 冒泡排序
     *
     * @param arr arr
     */
    private static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] > arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 基数排序
     * 用于大量数，很长的数进行排序时。
     * 将所有的数的个位数取出，按照个位数进行排序，构成一个序列。
     * 将新构成的所有的数的十位数取出，按照十位数进行排序，构成一个序列。
     *
     * @param a a
     */
    public static void baseSort(int[] a) {
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

        // 1.基数排序
        int[] a = {16, 8, 7, 50, 1, 26};
        baseSort(a);
        System.out.println(Arrays.toString(a));

        // 2.冒泡排序
        int[] arr = {12, 35, 99, 18, 76};
        bubble(arr);
        System.out.println(Arrays.toString(arr));

        // 3.桶排序
        int[] nums = {-1, -3, 0, 2, 4, 4, 3, 6, 9};
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
