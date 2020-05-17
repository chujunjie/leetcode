package solutions.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * @author chujunjie
 * @date Create in 9:58 下午 2020/5/17
 * @modified by
 */
public class Solution47 {
    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res, track, nums, used);
        return res;
    }

    /**
     * 回溯
     *
     * @param res   结果集
     * @param track 当前排列
     * @param nums  输入
     * @param used  标记使用记录
     */
    private static void backtrack(List<List<Integer>> res, List<Integer> track, int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝
            // !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(res, track, nums, used);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{3, 3, 0, 3}));
    }
}
