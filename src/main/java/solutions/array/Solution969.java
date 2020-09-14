package solutions.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
 * 我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 * <p>
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 *
 * @author chujunjie
 * @date Create in 19:35 2020/9/14
 */
public class Solution969 {

    /**
     * 输入：[3,2,4,1]
     * 输出：[4,2,4,3]
     * 解释：
     * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
     * 初始状态 A = [3, 2, 4, 1]
     * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
     * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
     * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
     * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
     *
     * @param arr arr
     * @return list
     */
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        return recursion(list, arr, arr.length - 1);
    }

    private static List<Integer> recursion(List<Integer> list, int[] arr, int mark) {
        if (mark <= 0) {
            return list;
        }

        int max = arr[0];
        int index = 0;
        for (int i = 1; i < mark; i++) {
            if (arr[i] > max) {
                index = i;
                max = arr[i];
            }
        }
        reverse(arr, 0, index);
        list.add(index + 1);

        reverse(arr, 0, mark);
        list.add(mark + 1);

        return recursion(list, arr, --mark);
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
