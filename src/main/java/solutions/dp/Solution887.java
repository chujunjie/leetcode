package solutions.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * @author chujunjie
 * @date Create in 20:37 下午 2020/5/6
 * @modified by
 */
public class Solution887 {

    private static final Map<Integer, Integer> MEMO = new HashMap<>();

    /**
     * 状态：【当前拥有的鸡蛋数 K】和【需要测试的楼层数 N】
     * 选择：【选择哪层楼扔鸡蛋】
     * base case: n = 0 时，不需要扔鸡蛋；k = 1 时，只能线性扫描所有楼层
     *
     * @param k 鸡蛋数量
     * @param n 楼层层数
     * @return 移动次数
     */
    private static int superEggDrop(int k, int n) {
        if (!MEMO.containsKey(n * 100 + k)) {
            int ans;
            if (n == 0) {
                ans = 0;
            } else if (k == 1) {
                ans = n;
            } else {
                int lo = 1, hi = n;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = superEggDrop(k - 1, x - 1);
                    int t2 = superEggDrop(k, n - x);

                    if (t1 < t2) {
                        lo = x;
                    } else if (t1 > t2) {
                        hi = x;
                    } else {
                        lo = hi = x;
                    }
                }

                ans = 1 + Math.min(Math.max(superEggDrop(k - 1, lo - 1), superEggDrop(k, n - lo)),
                        Math.max(superEggDrop(k - 1, hi - 1), superEggDrop(k, n - hi)));
            }

            MEMO.put(n * 100 + k, ans);
        }

        return MEMO.get(n * 100 + k);
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(3, 14));
    }
}
