package qa;

import java.util.Scanner;

/**
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * <p>
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * @author chujunjie
 */
public class Main23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] left = new int[n];
            int[] right = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            // 动态规划
            // 求最长递增子序列
            for (int i = 0; i < n; i++) {
                left[i] = 1;
                for (int j = i - 1; j >= 0; j--)
                    if (arr[j] < arr[i])
                        left[i] = Math.max(left[i], left[j] + 1);
            }

            // 求从右边数起的最长递减子序列
            for (int i = n - 1; i >= 0; i--) {
                right[i] = 1;
                for (int j = i + 1; j < n; j++)
                    if (arr[i] > arr[j])
                        right[i] = Math.max(right[i], right[j] + 1);
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, left[i] + right[i] - 1);
            }
            System.out.println(n - max);
        }
    }
}
