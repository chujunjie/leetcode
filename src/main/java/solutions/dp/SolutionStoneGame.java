package solutions.dp;

import solutions.datastructure.Pair;

/**
 * 博弈问题之石头游戏
 * 你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。
 * 你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。所有石头被拿完后，谁拥有的石头多，谁获胜。
 * <p>
 * 石头的堆数可以是任意正整数，石头的总数也可以是任意正整数，这样就能打破先手必胜的局面了。
 * 比如有三堆石头 piles = [1, 100, 3]，先手不管拿 1 还是 3，能够决定胜负的 100 都会被后手拿走，后手会获胜。
 * <p>
 * 假设两人都很聪明，请你设计一个算法，返回先手和后手的最后得分（石头总数）之差。
 * 比如上面那个例子，先手能获得 4 分，后手会获得 100 分，你的算法应该返回 -96。
 *
 * @author chujunjie
 * @date Create in 4:49 下午 2020/5/31
 */
public class SolutionStoneGame {

    private static int stoneGame(int[] piles) {
        int length = piles.length;

        // 初始化dp数组，dp数组表示从i到j这些石头堆时，先后手能拿到的最高分
        Pair[][] dp = new Pair[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        /*
         * base case
         * 对于只有一堆石头时，先手拿的一方得分为piles[i]，后手得分为0
         */
        for (int i = 0; i < length; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        /*
         * dp[i][j] 时需要用到 dp[i+1][j] 和 dp[i][j-1]
         * 所以需要斜着遍历数组
         */
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i <= length - l; i++) {
                // j始终比i大l-1，表示正在遍历的斜线距离原点的偏移量
                int j = l + i - 1;

                /*
                 * 先手选择最左边或最右边的分数
                 * 选择之后，均变成后手，即当前选择+去除当前选择项之后的后手最高得分
                 * 而对应的，后手变为先手，为去除当前选择项之后的先手最高得分
                 * dp[i][j].fir = max(选择最左边的石头堆，选择最右边的石头堆)
                 */
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;

                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }

        return dp[0][length - 1].fir - dp[0][length - 1].sec;
    }

    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{3, 9, 1, 2}));
    }
}
