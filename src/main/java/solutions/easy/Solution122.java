package solutions.easy;

/**
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author: chujunjie
 * @Date: Create in 15:07 2020/2/6
 * @Modified By
 */
public class Solution122 {

    public int maxProfit2(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }

    public static int maxProfit(int[] prices) {
        // 双指针
        int slow = 0;
        int fast = 0;
        int total = 0;
        int length = prices.length;
        while (fast < length && slow < length) {
            if (prices[fast] > prices[slow]) {
                total += prices[fast] - prices[slow];
                slow = fast;
            } else if (prices[fast] < prices[slow]) {
                slow++;
            } else {
                fast++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
}
