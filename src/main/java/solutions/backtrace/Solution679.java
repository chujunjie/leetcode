package solutions.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * @author chujunjie
 * @date Create in 21:49 2020/5/26
 * @modified by
 */
public class Solution679 {

    /**
     * 输入: [4, 1, 8, 7]
     * 输出: True
     * 解释: (8-4) * (7-1) = 24
     *
     * @param nums nums
     * @return boolean
     */
    private static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int v : nums) {
            list.add((double) v);
        }
        return solve(list);
    }

    /**
     * 回溯法，从数组中选出两个数，把运算结果加到数组中
     *
     * @param nums nums
     * @return boolean
     */
    private static boolean solve(List<Double> nums) {
        if (nums.size() == 0) {
            return false;
        }
        // 数组中只剩下一个数的时候判断结果，是否与24相等
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        // 从数组中选择两个数并将结果放入数组中
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                // i != j表示两个不同的树
                if (i != j) {
                    // 回溯需要恢复，所以需要一个辅助列表递归给下一层
                    List<Double> nums2 = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            // 将选择剩下的数都放入辅助列表
                            nums2.add(nums.get(k));
                        }
                    }

                    /*
                     * 计算两个选定的数在各运算符下的值
                     * k(0, +) k(1, *) k(2, -) k(3, /)
                     */
                    for (int k = 0; k < 4; k++) {
                        // 加乘时，ab与ba相同，去重
                        if (k < 2 && j > i) {
                            continue;
                        }
                        if (k == 0) {
                            nums2.add(nums.get(i) + nums.get(j));
                        }
                        if (k == 1) {
                            nums2.add(nums.get(i) * nums.get(j));
                        }
                        if (k == 2) {
                            nums2.add(nums.get(i) - nums.get(j));
                        }
                        if (k == 3) {
                            // 排除/0情况
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) {
                            return true;
                        }
                        // 撤销
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgePoint24(new int[]{4, 1, 8, 7}));
    }
}
