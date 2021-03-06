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
     * 希尔排序，采用希尔增量
     * 将数的个数设为n，取奇数k=n/2，将下标差值为k的数分为一组，构成有序序列。
     * 再取k=k/2 ，将下标差值为k的书分为一组，构成有序序列。
     * 重复第二步，直到k=1执行简单插入排序。
     *
     * @param a a
     */
    public static void shellSort(int[] a) {
        int j;
        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            // 共gap个组，每组插排
            for (int i = gap; i < a.length; i++) {
                int temp = a[i];
                for (j = i; j >= gap && temp < a[j - gap]; j -= gap)
                    a[j] = a[j - gap];
                a[j] = temp;
            }
        }
    }

    /**
     * 选择排序
     * 首先确定循环次数，并且记住当前数字和当前位置。
     * 将当前位置后面所有的数与当前数字进行对比，小数赋值给key，并记住小数的位置。
     * 比对完成后，将最小的值与第一个数的值交换。
     *
     * @param a a
     */
    public static void select(int[] a) {
        int len = a.length;
        // 循环次数
        for (int i = 0; i < len; i++) {
            int value = a[i];
            int position = i;
            // 找到最小的值和位置
            for (int j = i + 1; j < len; j++) {
                if (a[j] < value) {
                    value = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = value;
        }
    }

    /**
     * 快速排序
     * 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
     * 递归的将p左边和右边的数都按照第一步进行，直到不能递归。
     *
     * @param a a
     */
    public static void quick(int[] a) {
        quick(a, 0, a.length - 1);
    }

    private static void quick(int[] a, int start, int end) {
        if (start < end) {
            // 选基准值
            int baseNum = a[start];
            int temp;
            int i = start;
            int j = end;
            while (i < j) {
                while (baseNum <= a[j] && i < j) j--;
                while (baseNum >= a[i] && i < j) i++;
                if (i < j) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
            //最后将基准为与i和j相等位置的数字交换
            a[start] = a[i];
            a[i] = baseNum;
            quick(a, start, j - 1);
            quick(a, j + 1, end);
        }
    }

    /**
     * 归并排序
     * 分治思想：将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     *
     * @param arr arr
     */
    public static void merge(int[] arr) {
        int length = arr.length;
        int[] tmp = new int[length];
        merge(arr, tmp, 0, length - 1);
    }

    private static void merge(int[] arr, int[] tempArr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            merge(arr, tempArr, left, mid);
            merge(arr, tempArr, mid + 1, right);
            merge(arr, tempArr, left, mid, mid + 1, right);
        }
    }

    private static void merge(int[] arr, int[] tempArr, int leftPos, int leftEnd, int rightPos, int rightEnd) {
        int tmpPos = leftPos;
        int sum = rightEnd - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] < arr[rightPos])
                tempArr[tmpPos++] = arr[leftPos++];
            else tempArr[tmpPos++] = arr[rightPos++];
        }
        while (leftPos <= leftEnd)
            tempArr[tmpPos++] = arr[leftPos++];
        while (rightPos <= rightEnd)
            tempArr[tmpPos++] = arr[rightPos++];
        System.arraycopy(tempArr, tmpPos - sum, arr, tmpPos - sum, sum);
    }

    /**
     * 插入排序
     * 基本思想：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
     * 现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     *
     * @param a a
     */
    public static void insert(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (j = i; j > 0 && a[j - 1] > temp; j--)
                a[j] = a[j - 1];
            a[j] = temp;
        }
    }

    /**
     * 堆排序
     *
     * @param a a
     */
    public static void heap(int[] a) {
        int len = a.length;
        // 循环建堆
        for (int i = 0; i < len - 1; i++) {
            // 建堆
            buildMaxHeap(a, len - 1 - i);
            // 交换堆顶和最后一个元素
            swap(a, 0, len - 1 - i);
        }
    }

    /**
     * 交换方法
     *
     * @param data data
     * @param i    i
     * @param j    j
     */
    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    /**
     * 对data数组从0到lastIndex建大顶堆
     *
     * @param data      data
     * @param lastIndex lastIndex
     */
    private static void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 桶排序
     *
     * @param arr arr
     */
    public static void bucket(int[] arr) {

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
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
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
    public static void base(int[] a) {
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
        base(a);
        System.out.println(Arrays.toString(a));

        // 2.冒泡排序
        int[] arr = {12, 35, 99, 18, 76};
        bubble(arr);
        System.out.println(Arrays.toString(arr));

        // 3.桶排序
        int[] nums = {-1, -3, 0, 2, 4, 4, 3, 6, 9};
        bucket(nums);
        System.out.println(Arrays.toString(nums));

        // 4.堆排序
        int[] b = {16, 8, 7, 50, 1, 26};
        heap(b);
        System.out.println(Arrays.toString(b));

        // 5.插入排序
        int[] c = {16, 8, 7, 50, 1, 26};
        insert(c);
        System.out.println(Arrays.toString(c));

        // 6.归并排序
        int[] d = {16, 8, 7, 50, 1, 26};
        merge(d);
        System.out.println(Arrays.toString(d));

        // 7.快速排序
        int[] e = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
        quick(e);
        System.out.println(Arrays.toString(e));

        // 8.选择排序
        int[] f = {16, 8, 7, 50, 1, 26};
        select(f);
        System.out.println(Arrays.toString(f));

        // 9.希尔排序
        int[] k = {16, 8, 7, 50, 1, 26};
        shellSort(k);
        System.out.println(Arrays.toString(k));
    }
}
